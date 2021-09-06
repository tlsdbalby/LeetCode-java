package lby.com.dp;
/*
* 494. 目标和
*   给你一个整数数组 nums 和一个整数 target 。向数组中的每个整数前添加 '+' 或 '-' ，
*   然后串联起所有整数，可以构造一个 表达式 ：例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，
*   在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
* 解:
*   思路1: 暴力法 数组nums中每个元素可取 正+ 或 负-, 因此有2^nums.length种组合, 遍历所有组合, 对sum值为target的组合进行计数即可
*       但不知道怎么实现....
*   思路2: 动态规划法:01背包问题型
*       问题简化: 对于本问题来说, 可以视为将nums划分为两个子数组分别存放正数和负数, 正组a 和 负组b, 二者加和为target即a+b=target,
*           且我们可以使负组b中的元素也设为为正, 即变成a-b=target, 同时由于nums已知, 所以sum(nums)=a+b, 所以两个式子构成了二元一次方程
*           可以解得: a=(sum+target)/2, 因此问题转化成了:找到nums中, 和为a的组合数目.
*       1.确定dp数组以及其下标含义: 对于dp数组来说, dp[j]表示和值为j的组合的数目 0<= j <= a
*       2*.确定状态转移方程: dp[j]=dp[j](忽略nums[i])+dp[j-nums[i]](接收nums[i]) 这是一个新的转移方程!注意这种转移方程一定会有初始化值,不可能全为0,否则就永远都是0了!
*       3.确定dp数组如何初始化: 没有元素加入时, 和肯定为0, 因此dp[0]=1, j>=1处dp[j]=0
*       4.确定遍历顺序: nums任意顺序, dp从后向前
*       5.小规模问题下手算与算法一致性检验:
* */
public class Question494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum)
            return 0;
        int a = (sum + target);
        if (a % 2 != 0)
            return 0;
        a /= 2;
        int[] dp = new int[a+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = dp.length - 1; i >= num; i--) {
                dp[i] += dp[i-num];
            }
        }
        return dp[a];
    }
}
