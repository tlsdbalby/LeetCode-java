package lby.com.tencent;

import java.util.Arrays;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i] = getQ(a[i]);
        }
        for (int i = 0; i < n; i++) {
            b[i] = getQ(b[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int max = 0;
        int p1 = 0;
        int p2 = 0;
        while (p1 < n){
            if (a[p1] > b[p2]){
                max++;
                p2++;
            }
            p1++;
        }
        System.out.println(max);
    }
    private static int getQ(int num){
        int r =(short) Math.sqrt(num);
        int count = 0;
        if (r*r == num){
            count++;
            r--;
        }
        for (short j = 1; j <= r; j++) {
            if (num % j == 0){
                count += 2;
            }
        }
        return count;
    }
}
