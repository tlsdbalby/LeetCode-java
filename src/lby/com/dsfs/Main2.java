package lby.com.dsfs;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] e = new int[n+1];
        Arrays.fill(e, 1);
        int[][] nums = new int[k][3];
        for (int i = 0; i < k; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
            nums[i][2] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int cand = nums[i][2];
            if (cand == 1)
                continue;
            for (int j = nums[i][0]; j <= nums[i][1]; j++) {
                if (e[j] < cand)
                    e[j] = cand;
            }
        }
        long sum = 0;
        for (int i : e) {
            sum += i;
        }
        System.out.println(sum - 1);
    }
}
