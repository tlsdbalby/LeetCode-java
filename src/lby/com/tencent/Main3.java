package lby.com.tencent;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] chars = str.toCharArray();
        int p1 = 0;
        int p2 = 0;
        for (char aChar : chars) {
            if (aChar == '0')
                p1++;
            else p2++;
        }
        int max = p1 > p2 ? p1 : p2;
        System.out.println(max*(max-1)/2);
    }
}
