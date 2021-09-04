package lby.com.question;
/*
* 509. 斐波那契数
*   斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
* 解:
*   思路1: DP五部曲方法
*       1.确定dp数组以及其下标的含义: 对于斐波那契数列问题来说, dp[i]存放i的斐波那契值
*       2.确定状态推导方程: 题目显示给出 i的斐波那契值 = i-1的斐波那契 + i-2的斐波那契, 因此: dp[i]=dp[i-1]+dp[i-2]
*       3.dp数组如何初始化: 因为斐波那契是对于正数存在的, 因此, 0和1的斐波那契值无法从状态推导中得出,
*                        所以手动给出0和1的斐波那契值, 作为dp的初始化
*       4.确定dp数组遍历顺序: 通过推导方程可知, i的斐波那契值需要i-1和i-2的斐波那契值, 因此遍历顺序应该从小到大
*       5.小规模问题的手算与代码算的过程验证: 例如n=5, 0 1 1 2 3
*       优化: 对于求指定n的斐波那契值, 无需记录整个斐波那契数列, 因此dp可以缩短为两个值
*
*    思路2: 经典递归, 边界条件: n=0或n=1, 递归条件: 非边界条件
* */
public class Question509 {
    public static void main(String[] args) {
        fib(5);
    }
    public static int fib(int n) {
        if(n < 2)
            return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            System.out.println(dp[i]);
        }
        return dp[n];
    }

    public static int fibOpt(int n) {
        if(n < 2)
            return n;
        int prepre = 0;
        int pre = 1;
        for (int i = 2; i <= n; i++) {
            int temp = pre;
            pre = pre + prepre;
            prepre = temp;
        }
        return pre;
    }

    public static int fib2(int n) {
        if(n < 2)
            return n;
        return fib2(n-1) + fib2(n-2);
    }
}
