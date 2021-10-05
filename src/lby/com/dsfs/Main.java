package lby.com.dsfs;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

//        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2-o1));
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            int e = sc.nextInt();
//            if (!hashSet.contains(e)){
//                hashSet.add(e);
//                queue.add(e);
//            }
//        }
//        for (int i = 0; i < k - 1; i++) {
//            queue.poll();
//        }
//        System.out.println(queue.poll());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
            else break;
        }
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2-o1));
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < k; i++) {
            if (index + i < n){
                if (!hashSet.contains(nums[index + i])){
                    queue.add(nums[index + i]);
                    hashSet.add(nums[index + i]);
                }
            }
            if (index - i >= 0){
                if (!hashSet.contains(nums[index - i])){
                    queue.add(nums[index - i]);
                    hashSet.add(nums[index - i]);
                }
            }
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
