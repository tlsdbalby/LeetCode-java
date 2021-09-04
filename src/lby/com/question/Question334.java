package lby.com.question;
/*
* 334. 递增的三元子序列
*   给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
*   如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
* 解:
*   思路1: 贪心法, 将前n项维护几个标志位, 子序列:数量等于2的升序序列
*           min 原始序列中的最小值
*           max 多个子序列中最大值中的最小值
*           in  子序列是否存在
*         此解法只适用于长度为3的情况, 若长度为4,则需要记录候选子序列才行!
* */
public class Question334 {
    public static void main(String[] args) {

    }

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return false;
        int max = nums[0];
        int min = max;
        boolean in = false;
        for (int num : nums) {
            if (num > max){
                if (in)
                    return true;
                max = num;
                in = true;
            }
            else if (num < min)
                min = num;
            else if (num<= max && num > min) {
                max = num;
                in = true;
            }
        }
        return false;
    }
}
