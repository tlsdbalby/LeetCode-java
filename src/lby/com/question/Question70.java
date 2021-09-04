package lby.com.question;
/*
* 70. 爬楼梯
*   假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
*   注意：给定 n 是一个正整数
* 解:
*   思路1: 回溯法, 从n开始, 每次有两种走法, -1或者-2, 当正好到达0时, 则认为找到了一种走法, 进行累加.
*         但这种方法容易超时
*   思路2: 动态规划法,
*           1.确定dp数组以及下标含义: dp[i]表示i层楼有多少种上法
*           2.确定状态转移方程: dp[i] = dp[i-1] + dp[i-2] (i > 2)
*               解读 第i层可以由第i-1层步长为1得到, 也可以由i-2层步长为2得到(第i-2层不考虑步长为1的上法, 因为那样就成了i-1层!)
*           3.dp数组的初始化: 由于前两层无法通过推导得到, 所以手动赋值dp[1]=1(0+1), dp[2]=2(1+1 and 0+2)
*           4.确定dp数组的遍历顺序: 由于第i层的上法数量依赖于i-1和i-2层, 因此要从小到大遍历
*           5.小规模问题下手算与算法一致性验证: n=4 (1111 112 121 211 22) 共5种
*                                          n=4 => dp[3]+dp[2] = dp[2]+dp[1]+dp[2] = 5
*           优化: 当我们只需要第n层的上法数量时, 无需维持长度为n的dp数组, 只需要维持n-1和n-2的上法数量即可
*           注意: 本题其实是斐波那契数列的变形.
* */
public class Question70 {
    public static void main(String[] args) {

    }
    private int re1 = 0;
    public int climbStairs(int n) {
        getCount(n);
        return re1;
    }
    private void getCount(int n){
        if (n == 1){
            re1++;
            return;
        }
        if (n == 2){
            re1 += 2;
            return;
        }
        if (n > 0){
            getCount(n-1);
            getCount(n-2);
        }
    }

    public int climbStairs2(int n) {
        if (n < 3)
            return n;
        int prepre = 1;
        int pre = 2;
        for (int i = 3; i <= n; i++) {
            int temp = pre;
            pre = pre + prepre;
            prepre = temp;
        }
        return  pre;
    }
}
