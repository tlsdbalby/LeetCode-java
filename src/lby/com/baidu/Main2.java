package lby.com.baidu;

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.next();
        }
        for (String num : nums) {
            char[] chars = num.toCharArray();
            int index = 0;
            while (index < chars.length){
                if (chars[index] > '3')
                    break;
                else if (chars[index] == '0') {
                    chars[index] = '9';
                    index--;
                    chars[index]--;
                } else index++;
            }
            for (; index < chars.length; index++)
                chars[index] = '3';
            System.out.println(Long.parseLong(new String(chars)));
        }
    }
}
