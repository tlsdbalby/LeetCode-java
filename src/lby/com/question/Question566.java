package lby.com.question;
/*
* 566. 重塑矩阵
*   在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。\
*   给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
*   重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。如果具有给定参数的 reshape 操作是可行且合理的，
*   则输出新的重塑矩阵；否则，输出原始矩阵。
* 解：
*   思路1：功能实现，没啥算法，计算总元素个数，然后遍历一次填充结果数组
* */
public class Question566 {
    public static void main(String[] args) {
        int[][] mat = {{1, 2},{3, 4}};
        int[][] re = matrixReshape(mat, 1, 4);
        for (int[] ints : re) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int count = m * n;
        if (count != r * c)
            return mat;
        int[][] re = new int[r][c];
        //位置映射！
        for (int i = 0; i < count; i++) {
            re[i / c][i % c] = mat[i / n][i % n];
        }
        //笨办法：下标递进！
        for (int i = 0, j1 = 0, j2 = 0, k1 = 0, k2 = 0; i < count; i++) {
            if (j2 == n){
                j1++;
                j2 = 0;
            }
            if (k2 == c){
                k1++;
                k2 = 0;
            }
            re[k1][k2++] = mat[j1][j2++];
        }
        return re;
    }
}
