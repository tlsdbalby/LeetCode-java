package lby.com.offer;
/*
* 剑指 Offer 53 - II. 0～n-1中缺失的数字
*   一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
*   在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
* 解:
*   思路1:由于在递增和数组长度上有严格关系, 所以对比下标与元素值即可
* */
public class Offer53II {
    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int i = 0;
        for ( ; i < nums.length; i++) {
            if (i != nums[i])
                return i;
        }
        return i;
    }
}
