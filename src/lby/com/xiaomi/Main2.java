package lby.com.xiaomi;

import java.util.Scanner;
/*
*   给定一个从1到n的整数列表，从第一个数字开始计数，遇到3的倍数时，将该数从列表中删除，直至列表末尾。
*   在剩下的数字中，从第一个数字开始，继续之前的计数值，同样遇到3的倍数时，删除该数。循环上面的步骤，
*   直到列表中只剩下一个数字。根据指定的数字n，来判断最后剩下的数字是哪个。
* */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] a = new boolean[n];
        int p = 0;
        int three = 0;
        int count = 0;
        while (count < n-1){
            if (!a[p]){
                three++;
                if (three == 3){
                    a[p] = true;
                    count++;
                    three = 0;
                }
            }
            p++;
            if (p == n)
                p = 0;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i])
                System.out.println(i+1);
        }
    }
}
