package lby.com.question;

import java.util.Arrays;

/*
* 169. 多数元素
*   给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
*   你可以假设数组是非空的，并且给定的数组总是存在多数元素。
*   进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
* 解:
*   思路1: 因为题目规定多数元素是数量大于数组长度一半的, 因此可以对数组排序, 中间位置的元素一定是多数元素
*
*   思路2: 投票法, 参照官解, 很巧妙的思路!
*       本质上是利用多数元素的数量比其余元素加起来还多, 进行"消耗", 遍历整个数组, 最后必然剩下的是多数元素本身
* */
public class Question169 {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                candidate = nums[i];
                count++;
            } else {
                if (candidate == nums[i]){
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }
}
