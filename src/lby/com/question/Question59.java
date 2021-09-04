package lby.com.question;
/*
* 59. 螺旋矩阵 II
*   给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
* 解:
*   思路1: 数学规律法, 寻找填充顺序与填充值之间的规律, 一圈一圈填充值
* */
public class Question59 {
    public static void main(String[] args) {
        int[][] re = generateMatrix(1);
        for (int[] ints : re) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] arrs = new int[n][n];
        if (n % 2 != 0)
            arrs[(n-1)/2][(n-1)/2] = n * n;
        int init = 0;
        int num = 1;
        for (int i = n; i > 0; i-=1) {
            for (int j = init; j < i-1; j++) {
                arrs[init][j] = num++;
            }
            for (int j = init; j < i-1; j++) {
                arrs[j][i-1] = num++;
            }
            for (int j = i-1; j > init; j--) {
                arrs[i-1][j] = num++;
            }
            for (int j = i-1; j > init; j--) {
                arrs[j][init] = num++;
            }
            init++;
        }
        return arrs;
    }
}
