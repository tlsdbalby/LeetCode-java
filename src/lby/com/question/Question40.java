package lby.com.question;

import java.util.*;

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
                    }
                }
            }
        }
        if (index+1 < hashMapKey.size())
            dfx(target, index+1, combine);
    }

}
