package lby.com.dp;
/*
* 动态规划法之完全背包
*   特点: 在01背包的基础上, 我们假设每种物品的数量是无限的, 即物品可以重复放入背包(放回问题)
*   思路: 因为只是在91背包的基础上取消每种物品的数量限制, 因此大框架还是01背包, 只需小小改动即可
*       在完全背包问题中, dp滚动数组要正序顺序!!! 联立之前01背包中, 将dp滚动数组的遍历顺序定为逆序的原因是防止一种物品被重复放入!
*       如今我们的物品的数量限制没有了, 可以重复放入一种物品, 因此将遍历顺序定为正序, 即可得到完全背包问题的解!
* */
public class TotalPackage {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5, 7, 5, 6, 1};
        int[] value = {15, 40, 30, 70, 55, 60, 65, 14};
        int volume = 14;
        System.out.println(maxValue(weight, value, volume));
    }

    private static int maxValue(int[] weight, int[] value, int volume){
        int n = weight.length;
        if (n == 0)
            return 0;
        int[] dp = new int[volume+1];
        for (int i = 0; i < n; i++) {
            //从当前物品的重量开始正序遍历dp数组
            for (int j = weight[i]; j < dp.length; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]]+value[i]);
            }
            for (int i1 : dp) {
                System.out.print(i1 + " ");
            }
            System.out.println();
        }
        return dp[volume];
    }
}
