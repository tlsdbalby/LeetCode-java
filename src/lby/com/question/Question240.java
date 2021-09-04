package lby.com.question;
/*
* 240. 搜索二维矩阵 II
*   编写一个高效的算法来搜索 n x m 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
*   每行的元素从左到右升序排列。每列的元素从上到下升序排列。
* 解:
*   思路1: 数学法, 因为左小右大, 上小下大因此对于i*i的矩阵来说,[i,i]位置的元素最大,因此,从[0,0]开始,
*   找到一个大于target的主对角线元素的坐标[j,j],然后target如果存在,则必在 0到j行的j到m列 或 j行到n行的0到j列,
*   在这个范围进行遍历查找. (约等于 剪枝后遍历)
*
*   思路2: 官解中的方法4, 移步法, 很巧妙, 从n*m矩阵的左下角[r,c]=[n-1,0]开始, 若大于target则上移(r--),若小于target则右移(c++)
*   若找到则为true, 若到了[0,m-1]还没有找到则为false
* */
public class Question240 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = m > n ? n : m;
        int i = 0;
        boolean isFind = false;
        for (; i < l; i++) {
            if (target == matrix[i][i])
                return true;
            if (target < matrix[i][i]){
                isFind = true;
                break;
            }

        }
        if (!isFind)
            if (m == n)
                return false;
        for (int p1 = i; p1 < n; p1++){
            for (int j = 0; j < i; j++) {
                if (target == matrix[p1][j])
                    return true;
            }
        }
        for (int p2 = i; p2 < m; p2++){
            for (int j = 0; j < i; j++) {
                if (target == matrix[j][p2])
                    return true;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int r =  n - 1;
        int c = 0;
        while (r >= 0 && c <= m-1){
            if (target == matrix[r][c])
                return true;
            if (target > matrix[r][c])
                c++;
            else {
                r--;
            }
        }
        return false;
    }
}
