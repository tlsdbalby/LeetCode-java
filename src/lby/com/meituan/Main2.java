package lby.com.meituan;

import java.util.Arrays;
import java.util.Scanner;
/*
* dp五部曲:
*   1.确定dp数组的含义: dp[i][j]表示i本书在j个
* */
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
        Arrays.sort(a);
        Arrays.sort(b);
        long re = 1;
        for (int i = a.length - 1; i > 0;) {
            int j = i;
            System.out.println("j = " + j);
            while (a[i] <= b[j]){
                if (j == 0)
                    break;
                j--;
            }
            System.out.println("j = "+ j);
            re *= getNum(i-j);
            i = j;
        }
        System.out.println(re);
    }

    private static long getNum(int i){
        long re = 1;
        while (i > 0){
            re *= i--;
        }
        return re;
    }
}
