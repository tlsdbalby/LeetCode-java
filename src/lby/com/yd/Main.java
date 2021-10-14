package lby.com.yd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        List<Integer> needAdd = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            needAdd.add(i);
        }
        List<String> lists = new ArrayList<>();
        backTracking(chars, needAdd, lists, new ArrayList<>());
        System.out.println(lists);
        System.out.println(lists.size());
    }

    public static void backTracking(char[] chars, List<Integer> needAdd, List<String> lists, List<Character> list){
        if (needAdd.size() == 0){
            StringBuilder sb = new StringBuilder();
            for (Character character : list) {
                sb.append(character);
            }
            lists.add(sb.toString());
            return;
        }
        for (Integer integer : needAdd) {
            char c = chars[integer];
            list.add(c);
            List<Integer> t = new ArrayList<>(needAdd);
            t.remove(integer);
            backTracking(chars, t, lists, list);
            list.remove(list.size()-1);
        }
    }
}
