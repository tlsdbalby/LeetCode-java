package lby.com.dp;
/*
* 经典动态规划问题-01背包问题:
*   假设你有一个背包, 具有一定的容积vol, 同时你的面前有一堆物品, 每个物品都有相应的价值和体积,
*   你需要决定将哪些物品放入你的背包, 使得你获取最大的收获
*   五部曲:
*       1.确定dp数组和以及下标的含义: 因为要考虑两个因素 价值 和 体积, 所以dp设置为二维数组,
*           dp[i][j]表示在0-i个物品中, j容积的约束下, 可以获取的最大价值
*       2.确定状态推导方程: 对于dp[i][j], 当物品i可以放入j容积的背包时(j>=weight[i]), 一方面是加入i物品:通过0-(i-1)个物品,
*           j-weight[i]容积约束下的最大价值加上i物品的价值转移得到(即捕捉i物品), 另一方面是忽略i物品:0-(i-1)个物品,
*           j容积约束下已经达到了一个很高的价值i物品加入反而会降低价值(即不捕捉i物品), 因此dp[i][j]应该是二者中的较大者,
*           所以dp[i][j]=Max(dp[i-1][j-weight[i]]+value[i], dp[i-1][j])
*           当物品i压根无法放入j容积的背包时(j<weight[i]), 第i个物品约等于没有, 所以dp[i][j]=dp[i-1][j]
*           注意: 我们只关心最大价值, 而不关心是否把j容积完全填满, 有可能某个物品价值极高, 只能装它一个,
*               得到的价值也比加入其他很多个都高
*       3.确定dp数组如何初始化: 由于dp[0][j]时只有0号物品, 所以当j<0号物品的体积时都为0,j>=0号物品的体积时都是0号物品的价值;
*           dp[i][0]时无容积, 全为0
*       4.确定遍历顺序: 由于状态推导要依赖之前的状态, 所以从左到右 从上到下遍历
*       5.小规模问题的手算与算法的一致性验证
*
*    空间优化:
*       1.再看状态推导方程, dp[i][j]=Max(dp[i-1][j-weight[i]]+value[i], dp[i-1][j]),
*       可以发现dp[i]是完全基于dp[i-1]的推导, 因此对于只要最后结果的题目来说(大多数题目都只关心最终结果!),
*       完全不必要存储所有中间结果, 只需记录上个状态即可推导下个状态, 因此可以将i的长度限制到2,
*       即dp[1][]的计算用dp[0][], 并将新结果写入dp[0][], 此时dp的含义未发生变化, 还是0-i个物品在j容积限制下的最大价值
*       只是不存储i-1之前的最大价值了(因为再也没有用了!), 因此这个写法下, 后续所有步骤都不变!
*       2.在1基础上再做优化, 将dp换成一维数组dp[], 即用dp的数据(i-1个物品可取的最大价值)计算并将结果写入dp(i个物品可取最大价值),
*       此时dp含义发生了变化, dp[]一部分表示0-(i-1)个物品在?容积约束下的最大价值, 一部分表示0-i个物品在?容积约束下的最大价值,
*       此时后续步骤就要重新定义了
*           2.确定状态推导方程: 由于我们要得到i个物品在j容积下的最大值, 因此有两种还是有两种可能,
*              不加入第i个物品:(i-1)个物品在j容积下已经获得最大价值(即dp[j]); 加入第i个物品:从dp[j-weight[i]]的最大价值基础上加入第i个物品
*              因此dp[j]=Max(dp[j], dp[j-weight[i]]+value[i])
*           3.确定dp数组如何初始化: 当dp[j]的j>=0号物品的体积时,后续的dp都是0号物品的价值
*           4.确定遍历顺序: 此处是本优化重难点, 对于dp[j]来说, 我们的转移方程显示, 需要用到dp[0到j],
*               此时若是从0开始向后更新, 会造成物品i的重复计算!
*               例如: dp[2]在加入i物品后=3, 按照从前向后更新, 当dp[3]对i物品进行计算时, 若用到dp[2]则意味着将i物品重复加入了!!
*               所以对于dp数组的更新, 需要从后向前更新, 即按照dp.length-1 -> 0位置的元素进行转移. 由于转移方程只依赖之前的元素,
*               所以从后向前更新不会造成物品的重复计算!
*           5.小规模问题的手算与算法一致性验证
*
*   注意: 在01背包问题上, 空间优化确实很巧妙, 可以节省大量空间, 将n*L -> 1*L, 但空间优化归根到底是一种牺牲优化,
*       在优化的同时也增加了问题的抽象度, 尤其是dp数组的含义, 将更加复杂难想, 所以大可不必以这种形式作为解题路数,
*       算法题首先要做出来, 然后在有时间有余力的情况下再做优化; 同时必须要搞清楚题目要求, 因为有些01背包确实要用到中间结果!
*       此时上述空间优化就很不方便甚至不能解答! 因此, 在类似复杂问题上一定要把握主次! 莫要因小失大!
* */
public class ZeroOnePackage {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5, 7, 5, 6, 1};
        int[] value = {15, 40, 30, 70, 55, 60, 65, 14};
        int volume = 14;
        System.out.println(maxValue1(weight, value, volume));
        System.out.println(maxValue2(weight, value, volume));
    }

    public static int maxValue1(int[] weight, int[] value, int volume){
        int n = weight.length;
        int[][] dp = new int[n][volume+1];
        //java的int数组默认值为0, 因此只用初始化非0值即可
        for (int i = 0; i < volume + 1; i++) {
            if (i >= weight[0])
                dp[0][i] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < volume + 1; j++) {
                if (j-weight[i] >= 0)//j容积背包可以放入i物品
                    dp[i][j] = Math.max(dp[i-1][j-weight[i]]+value[i], dp[i-1][j]);
                else//i物品体积大于当前j容积背包
                    dp[i][j] = dp[i-1][j];
                if (i == n-1)
                    System.out.println(dp[i][j]);
            }
        }
        return dp[n-1][volume];
    }

    public static int maxValue2(int[] weight, int[] value, int volume) {
        int n = weight.length;
        int[] dp = new int[volume+1];
        for (int i = 0; i < dp.length; i++) {
            if (i >= weight[0])
                dp[i] = value[0];
        }

        for (int i = 1; i < value.length; i++) {
            for (int j = dp.length - 1; j > 0; j--) {
                if (j >= weight[i])
                    dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
                //由于在dp自身上转移, 所以当j<weight[i]时, dp[j]=dp[j], 即无需转移
            }
        }
        return dp[volume];
    }
}
