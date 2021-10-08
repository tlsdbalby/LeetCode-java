package lby.com.offer;
/*
* 剑指 Offer 11. 旋转数组的最小数字
*   把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
*   例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1.
* 条件提取: 递增有序数组旋转后可以视为两个有序数组的拼接, 第一个递增, 第二个也递增, 且第一个数组的尾一定是大于第二个数组的头!
*
* 解:
*   思路1:返回数组中第一个减小的元素, 否则返回头元素
* */
public class Offer11 {
    public static void main(String[] args) {

    }
    public int minArray(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i-1] > numbers[i])
                return numbers[i];
        }
        return numbers[0];
    }
}
