package lby.com.question;
/*
* 53. 最大子序和
*   给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
* 解:
*   思路1:暴力法,惨遭失败
*   思路2:动态规划,详见官解,很nice的动态规划思想
 * */
public class Question53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(nums));
    }
    // 暴力遍历O(n^3) 失败!
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int max = -9999;
        for (int i = 0; i < nums.length; i++) {
            for (int k = nums.length - 1; k >= i; k--) {
                int sum = 0;
                for (int j = i; j <= k; j++) {
                    sum += nums[j];
                }
                if (sum > max) max = sum;
            }
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int temp = 0;
        int max = nums[0];
        for (int num : nums) {
            temp = Math.max(num, temp+num);
            max = Math.max(max, temp);
        }
        return max;
    }
}
