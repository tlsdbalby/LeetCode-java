package lby.com.dp;
/*
* 416. 分割等和子集
*   给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
*
* 解:
*   思路1: 将一个数组拆分成两个, 且元素和相同, 因此元素和一定是原数组总和sum的一半, 记为sum/2, 因此可以用
*       暴力法找到原数组的和为sum/2的子数组, 但这样会超时....
*   思路2: 动态规划法: 由于题目中的nums数组是不放回/只取一次型, 因此可以用01背包思路解决
*       1.确定dp数组以及下标i的含义: 使用一维滚动数组来存放中间过程, dp[i]表示子数组元素和<=i时的最大值(即最大为i),
*           0 <= i <= sum/2(注意dp[]初始化长度应该是sum/2+1!)
*           且此题中, 因为无需考虑子数组长度, 只要凑到和为sum/2的子数组即可, 所以容积和价值都是nums[i],
*       2.确定状态转移方程: dp[i]=max(dp[i], dp[i-nums[i]]+nums[i](直接参考01背包的状态转移方程)
*       3.确定dp数组如何初始化: 因为nums本身是非负整数数组, 因此dp初始化为0即可, 若nums包含负数, 则应该初始化为负无穷
*       4.确定遍历顺序: 对于nums数组的遍历无需特殊对待, 正序倒序皆可, 对于dp数组, 由于采用的是一维滚动数组, 因此需要倒序遍历
*           且01背包问题中我们永远是拿候选数组(此处为nums)更新dp数组, 因此候选数组为外层, dp数组为内层
*       5.小规模下手算与算法一致性验证:
* */
public class Question416{
    public static void main(String[] args) {
        int[] nums = {5, 11, 1, 5};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        int[] dp = new int[target+1];
        for (int num : nums) {
            for (int i = dp.length - 1; i >= num; i--) {
                dp[i] = Math.max(dp[i], dp[i-num]+num);
            }
        }
        return dp[target] == target;
    }
}
