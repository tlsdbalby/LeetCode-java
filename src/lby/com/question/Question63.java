package lby.com.question;
/*
* 63. 不同路径 II
*   一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
*   机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
*   现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
* 解:
*   思路1: 动态规划法
*           1.确定dp数组以及下标含义: 因为是二维地图上移动, 所以dp[i][j]表示从[0][0]到[i][j]不经过障碍物共有多少条路径
*           2.确定状态转移方程: if(grid[i][j]==1) dp[i][j]=0 else dp[i][j]=dp[i-1][j]+dp[i][j-1]
*           3.确定dp如何初始化: 因为只能右移和下移, 所以上边和左边因被初始化为1,
*               若[0][j]或[i][0]有障碍物则当前位置及以后位置都初始化为0
*           4.确定遍历顺序: 因为只能右移和下移, 所以从左到右 从上到下遍历
*           5.小规模问题手算与算法一致性验证:
* */
public class Question63 {
    public static void main(String[] args) {

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;
        int[][] dp = new int[m][n];
        int access = 1;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1){
                access = 0;
            }
            dp[i][0] = access;
        }
        access = 1;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1){
                access = 0;
            }
            dp[0][i] = access;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
