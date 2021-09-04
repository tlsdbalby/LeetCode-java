package lby.com.question;
/*
* 121. 买卖股票的最佳时机
*   给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
*   你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
*   返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
*
* 解:
*   思路1:动态规划：类似于53题，本题设置两个量，一个记录购入价格；当目前价格减购入价格大于0时，即为可以盈利，因此继续向后，
*   若小于0时则已经跌破购买价格，因此用目前价格更新购入价格。一个记录最大盈利：每次盈利时更新最大盈利值
* */
public class Question121 {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int max = 0;
        for (int price : prices) {
            int benefit = price - buy;
            if (benefit <= 0){
                buy = price;
            } else {
                if (benefit > max)
                    max = benefit;
            }
        }
        return max;
    }
}
