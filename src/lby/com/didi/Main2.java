package lby.com.didi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (m == 0)
            System.out.println(1);
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            matrix[x][y] = true;
            matrix[y][x] = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isAdd = new boolean[n];
        queue.offer(0);
        isAdd[0] = true;
        int sum = 1;
        while (!queue.isEmpty()){
            int c = queue.poll();
            for (int i = 0; i < matrix[c].length; i++) {
                if (matrix[c][i] && !isAdd[i]){
                    queue.offer(i);
                    isAdd[i] = true;
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
