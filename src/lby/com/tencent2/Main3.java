package lby.com.tencent2;

import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        Stack<Character> s1 = new Stack<>();
        Stack<Long> s2 = new Stack<>();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            int j = i;
            while (j < len && (chars[j] >= 48 && chars[j] <= 57)){
                j++;
            }
            long num = Long.parseLong(str.substring(i, j));
            s2.push(num);
            System.out.println(s2);
            if (j == len)
                break;
            if (chars[j] == '@')
                s1.push('@');
            else if (chars[j] == 'x') {
                if (s1.isEmpty()){
                    s1.push('x');
                } else {
                    if (s1.peek() == '@'){
                        s1.pop();
                        long n1 = s2.pop();
                        long n2 = s2.pop();
                        long t = n2|(n1+n2);
                        s2.push(t);
                        System.out.println(s2);
                    }
                    s1.push('x');
                }
            } else {
                if (s1.isEmpty()){
                    s1.push('+');
                } else {
                    if (s1.peek() != '+') {
                        if (s1.peek() == '@') {
                            s1.pop();
                            long n1 = s2.pop();
                            long n2 = s2.pop();
                            long t = n2|(n1+n2);
                            s2.push(t);
                            System.out.println(s2);
                        } else if (s1.peek() == 'x') {
                            s1.pop();
                            long n1 = s2.pop();
                            long n2 = s2.pop();
                            long t = n1 * n2;
                            s2.push(t);
                            System.out.println(s2);
                        }
                        s1.push('+');
                    }
                }
            }
            i = j;
        }
        System.out.println(s1);
        while (!s1.isEmpty()){
            char c = s1.pop();
            if (c == '@') {
                long n1 = s2.pop();
                long n2 = s2.pop();
                long t = (n2 | (n1 + n2));
                s2.push(t);
                System.out.println(s2);
            } else if (c == 'x'){
                long n1 = s2.pop();
                long n2 = s2.pop();
                long t = (n1*n2);
                s2.push(t);
                System.out.println(s2);
            } else {
                long n1 = s2.pop();
                long n2 = s2.pop();
                long t = n1 + n2;
                s2.push(t);
                System.out.println(s2);
            }
        }
        System.out.println(s2.peek());
//        for (int i = 0; i < len; i++) {
//            int j = i;
//            while (j < len){
//                if (chars[j] >= 48 || chars[j] <= 57){
//                    j++;
//                }
//                else {
//                    long num = Long.parseLong(str.substring(i, j));
//                    System.out.println(num);
//                    s2.push(num);
//                    i = j;
//                    if (chars[j] == '@')
//                        s1.push('@');
//                    else if (chars[j] == 'x') {
//                        if (s1.peek() == '@'){
//                            s1.pop();
//                            long n1 = s2.pop();
//                            long n2 = s2.pop();
//                            s2.push(n1|(n1+n2));
//                        } else s1.push('x');
//                    } else {
//                        if (s1.peek() != '+'){
//                            if (s1.peek() == '@'){
//                                s1.pop();
//                                long n1 = s2.pop();
//                                long n2 = s2.pop();
//                                s2.push(n1|(n1+n2));
//                            } else if (s1.peek() == 'x'){
//                                s1.pop();
//                                long n1 = s2.pop();
//                                long n2 = s2.pop();
//                                s2.push(n1*n2);
//                            } else s1.push('+');
//                        }
//                    }
//                    break;
//                }
//            }
//            s2.push(Long.parseLong(str.substring(i, j)));
//        }
//        long sum = 0;
//        while (!s1.isEmpty()){
//            char c = s1.pop();
//            if (c == '@') {
//                long n1 = s2.pop();
//                long n2 = s2.pop();
//                sum += n1 | (n1 + n2);
//            } else if (c == 'x'){
//                long n1 = s2.pop();
//                long n2 = s2.pop();
//                sum += (n1*n2);
//            } else {
//                long n1 = s2.pop();
//                long n2 = s2.pop();
//                sum += (n1+n2);
//            }
//        }
//        System.out.println(sum);
    }
}
