package lby.com.jd;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        boolean s;
        int p1;
        do{
            s = true;
            p1 = 0;
            while (p1 < nums.length-2){
                int sum = Math.abs(nums[p1] - nums[p1+1]) + Math.abs(nums[p1+1] - nums[p1+2]);
                int c = Math.abs(nums[p1] - nums[p1+1]) + Math.abs(nums[p1] - nums[p1+2]);
                if (c > sum){
                    int t = nums[p1];
                    nums[p1] = nums[p1+1];
                    nums[p1+1] = t;
                    s = false;
                }
                p1++;
            }
        } while (!s);
        long re = 0;
        for (int i = 1; i < nums.length; i++) {
            re += (Math.abs(nums[i]-nums[i-1]));
        }
        System.out.println(re);
    }
}
