package lby.com.offer;
/*
* 剑指 Offer 04. 二维数组中的查找
*   在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
*   请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
* 解:
*   思路1:将n*m的矩阵扩充成r*r的(r=max(m,n),少的拿最后一行/列填充), r*r的对角线元素即为当前方阵的最大值, 通过target与对角线元素值进行比较,
*       可以确定target所在行/列, 再进行查找即可. 这个方法不太行...麻烦了, 没有充分利用题目条件
*   思路2:利用严格的增长性: 从左向右是单增, 从上到下也是单增, 因此对于n*m二维数组的右上角(0, m)来说, 向左是减小, 向下是增大, 即可从这里开始遍历,
*       target > e则向下, target < e则向左, 直到找到target或者到达左下角得出target不存在. (同理可得左下角(n, 0) 向上是减小, 向右是增大)
* */
public class Offer04 {
    public static void main(String[] args) {

    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0)
            return false;
        int m = matrix[0].length;
        int x = 0;
        int y = m - 1;
        while (x < n && y >= 0){
            int e = matrix[x][y];
            if (e == target)
                return true;
            else if (e < target)
                x++;
            else y--;
        }
        return false;
    }
}
