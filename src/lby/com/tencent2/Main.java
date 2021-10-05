package lby.com.tencent2;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int now = sc.nextInt();
            int first = 1;
            int second = first + now;
            if (now > 2){
                while (isS(second))
                    second++;
            }
            int third = second + now;
            if (now > 2){
                while (isS(third))
                    third++;
            }
            System.out.println(second * third);
        }
    }
    public static boolean isS(int n){
        if (n > 3){
            if (n % 2 == 0)
                return true;
            if (n % 3 == 0)
                return true;
            for (int i = 3; i < Math.sqrt(n) + 1; i+=2) {
                if (n % i == 0)
                    return true;
            }
        }
        return false;
    }
}
