package lby.com.question;
/*
* 55. 跳跃游戏
*   给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
*   数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个下标。
* 解:
*   思路1: 贪心法, 每一步走一格(最短距离), 然后维护一个可达的最大距离 l = max(l, index+nums[index]), index <= l
*   若在最大距离之内可以到达终点则true, 反之false
*   贪心策略:走最短的距离,保证不漏掉每一种可能 局部划分:增长式
* */
public class Question55 {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return true;
        int l = nums[0] + 0;
        int index = 0;
        while (index <= l){
            if (l >= n - 1)
                return true;
            l = Math.max(l, index+nums[index]);
            index++;
        }
        return false;
    }
}
