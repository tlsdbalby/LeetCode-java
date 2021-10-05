package lby.com.dsfs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] op = new int[n][3];
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String o1 = sc.next();
            if ("left".equals(o1))
                op[i][0] = 0;
            else
                op[i][0] = 1;
            String o2 = sc.next();
            if ("push".equals(o2)){
                int o3 = sc.nextInt();
                op[i][1] = 0;
                op[i][2] = o3;
            }
            else
                op[i][1] = 1;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(op[i][0] == 0){
                if (op[i][1] == 0){
                    queue.offerLast(op[i][2]);
                } else {
                    int e = queue.pollLast();
//                    if (pq.peek() == e)
                }
            } else {

            }
        }
    }
}
