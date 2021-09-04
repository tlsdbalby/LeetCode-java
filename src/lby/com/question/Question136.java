package lby.com.question;

import lby.com.sort.QuickSort;

import java.util.Arrays;
import java.util.HashMap;

/*
* 136. 只出现一次的数字
*   给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
*   说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
* 解:
*   思路1: 用HashMap, 第一次遍历数组,填充<值, 出现次数>, 第二次遍历HashMap, 找到出现次数为1的元素
*       这个方法是线性时间复杂度, 但使用到了额外空间
*   思路2: 先排序, 然后找与相邻元素不同的元素
*       这个方法时间是O(nlogn), 但无需额外空间
*
*   思路3: 使用异或运算, 巧解此题
*             1 任何数和 0 做异或运算，结果仍然是原来的数
*             2 任何数和其自身做异或运算，结果是 0
*             3 异或运算满足交换律和结合律
*          因为题目中有m个元素出现两次, 1个元素(e)出现一次,
*          因此可以采取: 同样的元素异或->0, 0与任何元素异或->元e素自身 ,异或交换律/结合律
*          将所有元素做异或,总会变成 e异或0 ->e ,进而得到结果
* */
public class Question136 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num))
                hashMap.put(num, hashMap.get(num)+1);
            else
                hashMap.put(num, 1);
        }
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) == 1)
                return integer;
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1])
                i++;
            else
                return nums[i];
        }
        return nums[nums.length-1];
    }

    public int singleNumber3(int[] nums) {
        int re = 0;
        for (int i = 0; i < nums.length; i++) {
            re = re ^ nums[i];// 等价于 re ^= nums[i]
        }
        return re;
    }
}
