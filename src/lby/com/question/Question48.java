package lby.com.question;
/*
* 48. 旋转图像
*   给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
*   你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像
* 解:
*   思路1: 坐标转换 找下标变换的规律 没找到.....
*   思路2: 先转置, 然后交换列的位置
* */
public class Question48 {
    public static void main(String[] args) {

    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j)
                    continue;
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        int[] col = new int[n];
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                col[j] = matrix[j][i];
            }
            for (int j = 0; j < n; j++) {
                matrix[j][i] = matrix[j][n-1 - i];
            }
            for (int j = 0; j < n; j++) {
                matrix[j][n-1 - i] = col[j];
            }
        }
    }
}
