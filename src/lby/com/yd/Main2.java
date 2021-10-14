package lby.com.yd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        List<String> list = new ArrayList<>();
        backTracking(chars, list, 0, chars.length - 1);
        System.out.println(list);
    }
    public static void backTracking(char[] chars, List<String> hashSet, int s, int e){
        if (s == e){
            hashSet.add(new String(chars));
            return;
        } else {
            for (int i = s; i <= e; i++) {
                swap(chars, s, i);
                backTracking(chars, hashSet, s + 1, e);
                swap2(chars, s, i);
            }
        }
    }
    public static void swap(char[] chars, int p1, int p2){
        char t = chars[p2];
        for (int i = p2; i > p1; i--) {
            chars[i] = chars[i - 1];
        }
        chars[p1] = t;
    }
    public static void swap2(char[] chars, int p1, int p2){
        char t = chars[p1];
        for (int i = p1; i < p2; i++) {
            chars[i] = chars[i + 1];
        }
        chars[p2] = t;
    }
}
