package lby.com.question;

import java.util.HashSet;

public class Question217 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            //HashSet的add()返回值boolean表示加入成功与否，在一般情况下，加入失败就意味着元素冲突
            if (!hashSet.add(num))
                return true;
        }
        return false;
    }
}
