package lby.com.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question1 {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;

        int[] re = twoSum(nums, target);
        for (int i : re) {
            System.out.print(i);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        boolean isFinish = false;
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])){
                if (target == nums[i]*2){
                    list.add(hashMap.get(nums[i]));
                    list.add(i);
                    isFinish = true;
                    break;
                }
            } else {
                hashMap.put(nums[i], i);
            }
        }
        if (!isFinish){
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (hashMap.containsKey(temp)){
                    int j = hashMap.get(temp);
                    if (i != j){
                        list.add(i);
                        list.add(j);
                        break;
                    }
                }
            }
        }
        int[] re = new int[list.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = list.get(i);
        }
        return re;
    }

    public static int[] twoSum2(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (hashMap.containsKey(other)){
                list.add(hashMap.get(other));
                list.add(i);
                break;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        int[] re = new int[list.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = list.get(i);
        }
        return re;
    }
}
