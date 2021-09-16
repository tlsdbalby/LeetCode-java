package lby.com.question;

import java.util.*;
/*
* 早期的野路子:
*   将这个问题向39问题转化, 将candidates过滤成无重复元素的hashMapKey, 同时记录一个hashMap, 记录hashMapKey中每个元素的个数(>=1)
*   回溯的策略: 对于元素e, 捕捉 与 跳过两种可能, 对于捕捉e, 则要遍历e的每一种重复次数, 跳过e则直接到下一元素
*   整体来说也还行, 虽然空间上多耗了一点, 但思路上基本是回溯+剪枝的思想了, 正规路子看bt包下的Question40
* */
public class Question40 {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> hashMapKey = new ArrayList<>();
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    public static void main(String[] args) {
        int[] a = {10,1,2,7,6,1,5};
        combinationSum2(a, 8);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        for (int candidate : candidates) {
            if (hashMap.containsKey(candidate))
                hashMap.put(candidate, hashMap.get(candidate)+1);
            else{
                hashMap.put(candidate, 1);
                hashMapKey.add(candidate);
            }
        }
        hashMapKey.sort((o1, o2) -> o1-o2);
        System.out.println(hashMapKey);
        dfx(target, 0, new ArrayList<>());
        return result;
    }

    public static void dfx(int target, int index, List<Integer> combine){
        if (target == 0){
            result.add(combine);
            return;
        }
        if (index < hashMapKey.size()){
            int element = hashMapKey.get(index);
            if (element <= target){
                int count = hashMap.get(element);
                for (int i = 0; i < count; i++) {
                    int res = (i+1)*element;
                    if (res <= target){
                        List<Integer> c = new ArrayList<>(combine);
                        for (int j = 0; j < i+1; j++) {
                            c.add(element);
                        }
                        dfx(target-res, index+1, c);
                    } else break;
                }
            }
        }
        if (index+1 < hashMapKey.size())
            dfx(target, index+1, combine);
    }

}
