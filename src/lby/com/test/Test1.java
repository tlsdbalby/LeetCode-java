package lby.com.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
//        method2();
        Scanner in = new Scanner(System.in);
        int n = 0;
        int[] a = null;
        int[] b = null;
        int[] c = null;// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        n = in.nextInt();
        a = new int[n];
        b = new int[n];
        c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int p1 = 0, p2 = 0, p3 = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (a[p1] <= b[p2]){
                if (a[p1] <= c[p3]){
                    sum += a[p1];
                    p1++;
                } else {
                    sum += c[p3];
                    p3++;
                }
            } else {
                if (b[p2] <= c[p3]){
                    sum += b[p2];
                    p2++;
                } else {
                    sum += c[p3];
                    p3++;
                }
            }
        }
        System.out.println(sum);
    }
    static void method2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[3*n];
        for (int i = 0; i < 3*n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=a[i];
        }
        System.out.println(sum);
    }
}
/*
*
* 1 1 1 5 5
* 2 2 3 3 6
* 1 2 3 4 5
* */