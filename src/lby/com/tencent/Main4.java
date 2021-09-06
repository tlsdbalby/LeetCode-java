package lby.com.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long l = sc.nextLong();
        long r = sc.nextLong();
        List<Long> list = new ArrayList<>();
        long t = n;
        while (t >= 1){
            t /= 2;
            list.add(t);
        }
        System.out.println(list);

//        long re = n;
//        for (int i = list.size() - 1; i >= 0 && l > 0; i--) {
//            long temp = (long) Math.pow(2, i+1)-1;
//            long e = list.get(i);
//            if (l >= temp){
//                re -= e;
//                l -= temp;
//                if (l >= 1){
//                    re -= list.get(i+1)%2;
//                    l--;
//                }
//            }
//        }
//        for (int i = list.size() - 1; i >= 0; i--) {
//
//        }
    }
}
