package lby.com.offer;

import java.util.HashSet;

/*
* 剑指 Offer 03. 数组中重复的数字
*   找出数组中重复的数字:在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
*   但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
* 解:
*   思路1:用hashSet保持元素, 若出现重复则输出
* */
public class Offer03 {
    public static void main(String[] args) {

    }
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num))
                return num;
            else hashSet.add(num);
        }
        return -1;
    }
}
