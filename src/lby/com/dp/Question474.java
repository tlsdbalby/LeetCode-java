package lby.com.dp;
/*
* 474. 一和零
*   给你一个二进制字符串数组 strs 和两个整数 m 和 n 。请你找出并返回 strs 的最大子集的大小，
*   该子集中 最多 有 m 个 0 和 n 个 1 。如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
* 解:
*   思路1:动态规划法01背包问题型
*       问题简化: 本题可以视为找到二重约束下的01背包问题, 将01背包问题扩展成 容积约束+另一个约束然后求能放入物品的最大数量!
*       需要注意的是dp要设为滚动二维数组, 遍历还是要从后向前!
*       1.确定dp数组及下标含义: dp[i][j]表示有最多i个0和最多i个1时, 子集的最大长度
*       2.确定状态转移方程: dp[i][j]=max(dp[i][j], dp[i-strs_0[k]][j-strs_1[k]]+1)
*       3.确定dp数组如何初始化: 当i>=strs_0[0]并且j>=strs_1[0]时dp[i][j]=1, 其余=0
*       4.确定遍历顺序: strs正序, 为了防止物品的重复计算dp必须逆序(虽然此处看着是二维, 但此二维非01经典背包中的二维, 此时是二维滚动数组!)
*       5.小规模问题下手算与算法的一致性检验
* */
public class Question474 {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5, 3));

    }
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            char[] chars = str.toCharArray();
            int a = 0;
            int b = 0;
            for (char c : chars) {
                if (c == '0')
                    a++;
                else b++;
            }
            for (int i = dp.length-1; i >= a; i--) {
                for (int j = dp[i].length-1; j >= b; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-a][j-b]+1);
                }
            }
            for (int[] ints : dp) {
                for (int anInt : ints) {
                    System.out.print(anInt+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        return dp[m][n];
    }
}
