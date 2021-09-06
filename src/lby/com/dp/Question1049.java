package lby.com.dp;
/*
* 1049. 最后一块石头的重量 II
*   有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
*   每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。
*   那么粉碎的可能结果如下：如果 x == y，那么两块石头都会被完全粉碎；如果 x != y，
*   那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
*   最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
* 解:
*   这道题需要对题目进行简化, 才能明白题目是要求什么, 才能决定使用什么算法思路, 其实本题说是每回合两个石头相撞,
*   对整个石头数组来说就是将石头数组分为两堆, 使二者的差值尽量小, 即求差值最小的两个石头堆的差值. 假设石头数组总重sum,
*   当两个石头堆的重量分别是 sum/2 时, 差值为0, 此时即为所能取到的最小差值, 但由于石头堆中的元素是一个个石头(有具体大小, 不可拆分),
*   所以大多数情况不能取到 sum/2, 而是sum/2+e和sum/2-e, 因此题目再次简化为: 求石头堆<=sum/2时的最大值!
*   思路1: 暴力法, 将所有元素遍历组合, 得到最接近值um/2的子数组, 但本问题属于NP问题, 会超时......
*   思路2: 动态规划法: 01背包问题型
*       1.确定dp数组及其下标含义: dp[j]表示容积(最大重量)为j时, 所能得到的最大重量(一定是<=j的), 0<=j<=sum/2
*       2.确定状态转移方程: 此时容积是重量, 价值也是重量, 因此套用公式: dp[j]=max(dp[j], dp[j-nums[i]]+nums[i])
*       3.确定dp数组如何初始化: 由于是求每个状态下的最大值, 且元素均>0, 所以dp初始化为0即可
*       4.确定dp数组遍历顺序: 石头数组nums在外层, 任意顺序遍历都行, dp数组在内层, 因为采用了一维滚动数组, 所以要倒序遍历
*       5.小规模问题手算与算法一致性检验:
* */
public class Question1049 {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeightII(stones));
    }

    public static int lastStoneWeightII(int[] stones) {
        if (stones.length == 1)
            return stones[0];
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target+1];
        for (int stone : stones) {
            for (int j = dp.length - 1; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j-stone]+stone);
            }
            if (dp[target] == target)
                break;
        }
        return sum-dp[target]*2;
    }
}
