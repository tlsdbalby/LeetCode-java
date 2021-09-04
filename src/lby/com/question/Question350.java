package lby.com.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* 350. 两个数组的交集 II
*   内容:给定两个数组，编写一个函数来计算它们的交集。
*
* 解:
*   思路1:将一个数组装入hashMap中,key是元素,value是出现次数,然后遍历另一个数组,看其元素是否在hashMap中,
*       若在则找到一个重复元素,value-1;当value>0时可以重复此元素
* */
public class Question350 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] re = intersect(nums1, nums2);
        for (int i : re) {
            System.out.print(i);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        //这段的意义是调优:将小数组做成hashMap,遍历大数组查重,为了节省空间(也有部分时间),
        // 例如nums1有10000个,nums2有10个,此时若是将nums1做成hashMap无论是空间成本还是散列表映射函数计算成本都远大于将nums2做成hashMap的情况,这就是细节上的调优!
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums1) {
            if (hashMap.containsKey(i)){
                hashMap.put(i, hashMap.get(i)+1);
            } else {
                hashMap.put(i, 1);
            }
        }
        for (int i : nums2) {
            if (hashMap.containsKey(i)){
                if (hashMap.get(i) > 0){
                    list.add(i);
                    hashMap.put(i, hashMap.get(i)-1);
                }
            }
        }
        int[] re = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            re[i] = list.get(i);
        }
        return re;
    }
}
