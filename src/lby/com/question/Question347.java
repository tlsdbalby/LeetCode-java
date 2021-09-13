package lby.com.question;

import java.util.*;

/*
* 347. 前 K 个高频元素
*   给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
* 解:
*   思路1:hashMap放数字和频率, 遍历nums更新hashMap, 然后使用优先级队列, 将每个数字和频率包装后入队, 获取优先级队列的前k个即可
* */
public class Question347 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        for (int i : topKFrequent(nums, 2)) {
            System.out.println(i);
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] re = new int[k];
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int num : nums){
            if (hashMap.containsKey(num)){
                hashMap.put(num, hashMap.get(num)+1);
            } else hashMap.put(num, 1);
        }
        Queue<int[]> queue = new PriorityQueue<int[]>(hashMap.size(), new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Integer integer : hashMap.keySet()) {
            queue.offer(new int[]{integer, hashMap.get(integer)});
        }
        for (int i = 0; i < re.length; i++) {
            re[i] = queue.poll()[0];
        }
        return re;
    }
    class Fl{
        int e;
        int q;
        public Fl(int e, int q) {
            this.e = e;
            this.q = q;
        }
    }
}
