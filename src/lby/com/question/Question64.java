package lby.com.question;

import java.util.Arrays;

/*
* 664. 奇怪的打印机
*   有台奇怪的打印机有以下两个特殊要求：打印机每次只能打印由 同一个字符 组成的序列。
*   每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
*   给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数.
* 解:
*   思路1:官解下面的其他解, 总体来说用动态规划的思维解决, 注意不是背包类型!
*       1.确定dp数组及其下标含义: dp[i][j]表示字符串i到j位置最少的打印次数(j>i部分无意义)
*       2.确定条件转移方程: 当s[i]==s[j]时, dp[i][j]=dp[i][j-1],
*           若不等时, dp[i][j]=min(dp[i][j], dp[i][k]+dp[k+1][j]) k=[i, j] 遍历每一种拆分可能, 并获取最小值
*       3.确定dp数组如何初始化: dp[i][i] = 1
*       4.确定dp数组如何遍历: 从后向前
* */
public class Question64 {
    public static void main(String[] args) {

    }
    public int strangePrinter(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j])
                    dp[i][j] = dp[i][j-1];
                else {
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]);
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}
