package lby.com.dp;
/*
* 518. 零钱兑换 II
*   给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
*   请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
*   假设每一种面额的硬币有无限个。 题目数据保证结果符合 32 位带符号整数。
* 解:
*   思路1:暴力法递归, 累加和, 然后对于数组第i个元素可以跳过可以重复, 但是肯定会超时......
*   思路2:动态规划法 完全背包问题
*       1.确定dp数组及其下标含义: dp[j]表示硬币和=j的组合数量
*       2.确定状态转移方程: dp[j]=dp[j]+dp[j-coins[i]]
*       3.确定dp数组如何初始化: 拿coins[0]去填充dp[j], dp[0]=1 因为钱币总和=0就一种方法即什么都不拿
*       4.确定dp数组遍历顺序: coins正序/逆序皆可, dp正序!
*       5.小规模问题的手算与算法一致性检验:
*
* */
public class Question518 {
    private static int re = 0;
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int target = 5;
//        re = 0;
//        getCount(0, -1, coins, target);
//        System.out.println(re);
        System.out.println(getCountDp(coins, target));

    }
    private static void getCount(int sum, int i, int[] coins, int target){
        sum += coins[i];
        if(sum == target){
            System.out.println(i);
            re++;
        } else if (sum < target) {
            getCount(sum, i, coins, target);
            getCount(sum, i+1, coins, target);
        }
    }

    private static int getCountDp(int[] coins, int amount){
        if (amount == 0)
            return 1;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
            for (int k : dp) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        return dp[amount];
    }
}
