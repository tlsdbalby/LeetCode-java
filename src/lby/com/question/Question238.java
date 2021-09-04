package lby.com.question;
/*
* 238. 除自身以外数组的乘积
*   给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output
*   其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
* 解:
*   思路1: 官解的左右乘积数组, 设置L和R数组, L[i]上存放nums[i]的左数乘积, L[0]=1, L[i]=L[i-1]*nums[i-1]
*   R同理, L与R的填充都是O(n), 最后的结果可以表示为re[i]=L[i]*R[*]
* */
public class Question238 {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        int[] re = new int[n];
        L[0] = R[n-1] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i-1] * nums[i-1];
            R[n-1-i] = R[n-i] * nums[n-i];
        }
        for (int i = 0; i < re.length; i++) {
            re[i] = L[i]*R[i];
        }
        return re;
    }
}
