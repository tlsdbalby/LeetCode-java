package lby.com.question;

import java.util.Arrays;

/*
* 560. 和为K的子数组
*   给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
* 解:
*   思路1: 因为是连续的数组, 所以可以用双指针来确定上下边界, 用双指针遍历寻找合法组合.(然鹅, 可以有负值...因此此法不成立)
*   思路2: 枚举法, 对于i元素, 遍历i到length的所有可能,O(n^2)
* */
public class Question560 {
    public static void main(String[] args) {
        int[] nums = {1, -1, 0};
        subarraySum(nums, 0);
    }

    public static int subarraySum(int[] nums, int k) {
        int p1, p2, count;
        p1 = p2 = count = 0;
        while (p1 < nums.length){
            int sum = 0;
            p2 = p1;
            while (p2 < nums.length){
                sum += nums[p2];
                if (sum == k){
                    count++;
                }
                p2++;
            }
            p1++;
        }
        return count;
    }
}
