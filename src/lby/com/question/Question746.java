package lby.com.question;
/*
* 746. 使用最小花费爬楼梯
*   数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）
*   每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
*   请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
* 解:
*   思路1: 动态规划法
*           1.确定dp数组及下标含义: dp[i]表示上到第i层最小的花费
*           2.确定状态转移方程: dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])
*           3.对dp数组进行初始化: dp[0]=0 dp[1]=0
*           4.确定遍历顺序: 因为需要之前状态, 所以从小到大
*           5.小规模问题的手算与算法一致性验证: cost=[2, 5, 7, 4, 8, 2] dp=[0, 0, 2, 5, 9, 9, 11]
*           注意: 题目要求是上到楼顶, 因此是cost.length+1楼
 * */
public class Question746 {
    public static void main(String[] args) {
        int[] cost = {2, 5, 7, 4, 8, 2};
        System.out.println("最小代价:"+minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n < 2)
            return 0;
        int[] dp = new int[n+1];//因为数组默认值是0, 所以无需对dp[0]和dp[1]赋0
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
            System.out.println(dp[i]);
        }
        return dp[n];
    }
}
