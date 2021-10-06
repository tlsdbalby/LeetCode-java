package lby.com.tencent2;

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] nums = new int[m];
            int max = 0;
            for (int j = 0; j < nums.length; j++) {
                nums[j] = sc.nextInt();
            }

            for (int j = 0; j < nums.length; j++) {
                int sum = nums[j];
                int index = j+nums[j];
                while (index < nums.length){
                    sum += nums[index];
                    index = index+nums[index];
                }
                if (sum > max)
                    max = sum;
            }
            System.out.println(max);
        }
    }
}
