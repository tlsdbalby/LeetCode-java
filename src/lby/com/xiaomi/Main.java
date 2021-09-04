package lby.com.xiaomi;

import java.util.Scanner;
/*
* 两个数组有序合并
*   给定两个有序整数数组 A 和 B，将B合并到A中，使得 A 成为一个有序数组。
*   说明:
*       1. 初始化 A 和 B 的元素数量分别为 m 和 n。
*       2. A有足够的空间（空间大小大于或等于 m + n）来保存 B 中的元素。
*       3. 默认升序。
* */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        int m = Integer.valueOf(s1.split(",")[0].split("=")[1]);
        int n = Integer.valueOf(s1.split(",")[1].split("=")[1]);
        int[] a = new int[m+n];
        int[] b = new int[n];
        for (int i = 0; i < m; i++) {
            a[i] = Integer.valueOf(s2.split(",")[i]);
        }
        for (int i = 0; i < n; i++) {
            b[i] = Integer.valueOf(s3.split(",")[i]);
        }
        int p1 = m-1;
        int p2 = n-1;
        int p3 = m+n-1;
        while (p1 >= 0 && p2 >= 0){
            if (a[p1] > b[p2]){
                a[p3] = a[p1];
                p1--;
            } else {
                a[p3] = b[p2];
                p2--;
            }
            p3--;
        }
        while (p2 >= 0){
            a[p3--] = b[p2--];
        }
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
}
