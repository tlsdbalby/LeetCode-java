package lby.com.jd;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] processMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            if (r == 0)
                continue;
            for (int j = 0; j < r; j++) {
                int p = sc.nextInt();
                processMap[i][p-1] = 1;
            }
        }
        for (int[] ints : processMap) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
        int[][] orders = new int[m][2];
        for (int i = 0; i < m; i++) {
            orders[i][0] = sc.nextInt();
            orders[i][1] = sc.nextInt()-1;
        }
        for (int[] ints : orders) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
        boolean[] isAlive = new boolean[n];
        boolean hasAlive = false;
        for (int[] order : orders) {
            if (!hasAlive && order[0] == 0)
                continue;
            if (order[0] == 1){
                int p = order[1];
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(p);
                while (!queue.isEmpty()){
                    int cur = queue.poll();
                    if (!isAlive[cur]){
                        isAlive[cur] = true;
                        for (int i = 0; i < processMap[cur].length; i++) {
                            if (processMap[cur][i] == 1)
                                queue.offer(i);
                        }
                    }
                }
            } else {
                int p = order[1];
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(p);
                while (!queue.isEmpty()){
                    int cur = queue.poll();
                    if (isAlive[cur]){
                        isAlive[cur] = false;
                        for (int i = 0; i < processMap.length; i++) {
                            if (processMap[i][cur] == 1)
                                queue.offer(i);
                        }
                    }
                }
            }
            int alive = 0;
            for (boolean b : isAlive) {
                if (b)
                    alive++;
            }
            if (alive > 0)
                hasAlive = true;
            else hasAlive = false;
            System.out.println(alive);
        }
    }
}
