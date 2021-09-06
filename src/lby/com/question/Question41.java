package lby.com.question;

public class Question41 {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};

        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int top = nums.length;
        boolean[] booleans = new boolean[top+1];
        for (int num : nums) {
            if (num > top)
                continue;
            if (num <= 0)
                continue;
            booleans[num] = true;
        }
        for (int i = 1; i < booleans.length; i++) {
            if (!booleans[i]){
                return i;
            }
        }
        return top+1;
    }
}
