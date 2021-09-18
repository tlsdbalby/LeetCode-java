package lby.com.dp;

import java.util.Arrays;

/*
* 322. 零钱兑换
*   给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
*   计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
*   你可以认为每种硬币的数量是无限的。
* 解:
*   思路1:动态规划法
*       1.确定dp数组元素及下标的含义: dp[j]表示总金额为j时,硬币数量最少的硬币组合的数量
*       2.确定状态转移方程: dp[j]=min(dp[j], dp[j-coins[i]]+1) 其中dp[j]表示第0~i-1种硬币的硬币组合数量最少, dp[j-coins[i]]+1表示用到第i个硬币的组合数量最少
*       3.确定dp数组如何初始化: dp[0]=0, 其余赋为amount+1
*       4.确定dp数组的遍历顺序: 因为是求组合数的完全背包问题, 所以coins在外任意序, dp在内正序
*       5.小规模问题手算与算法的一致性检验:
*
*   注意:这道题不是求最大了, 而是求最小, 因此两个方面需要注意
*           1.dp数组的状态转移方程, 要取小, 且注意增长方式(此处是求数量,因此是+1,要是求价值则是+价值)
*           2.dp数组的初始化, 要将空位置赋为一个求解过程中不可能取到的大值, 一般来说可以使用int的上限, 也可以是按照题意分析出的大值,
*               例如此处, 因为求金额为j的硬币组合中最多是全用面值为1的硬币, 因此最多是amount+1
* */
public class Question322 {
    public static void main(String[] args) {
        int[] coins = {4, 5};
        System.out.println(coinChange(coins, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i : dp) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int j = 0; j < dp.length; j++) {
                if (j >= coin)
                    dp[j] = Math.min(dp[j], dp[j-coin]+1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE-1 ? -1 : dp[amount];
    }
}
