package lby.com.question;
/*
* 62. 不同路径
*   一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
*   机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
*   问总共有多少条不同的路径？
* 解:
*   思路1: 动态规划法
*           1.确定dp数组及下标的含义: 这道题中, dp应该是二维数组, dp[i][j]表示机器人从[0][0]到第i行第j列格子共有几条路径
*           2.确定状态转移方程: 因为机器人只能进行右移和下移, 因此dp[i][j]=dp[i][j-1]+dp[i-1][j]
*           3.确定dp的初始化值: 因为只能进行右移和下移, 因此处于上边和左边上的方块, 都只能有一条路径到达,
*               因此dp[i][0]=dp[0][j]=1
*           4.确定遍历顺序: 因为dp[i][j]需要左邻居[i][j-1]和上邻居[i-1][j]的可能路径, 所以从左到右,从上到下遍历
*           5.小规模问题手算和算法的一致性验证:
* */
public class Question62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
