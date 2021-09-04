package lby.com.question;
/*
* 45. 跳跃游戏 II
*   给你一个非负整数数组 nums ，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
*   你的目标是使用最少的跳跃次数到达数组的最后一个位置。假设你总是可以到达数组的最后一个位置。
* 解:
*   思路1: 贪心法, 局部最优:每次选择可达到范围内的新最大步长 -> 全局最优: 总步数最少
*           局部划分: 增长式
* */
public class Question45 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int n = nums.length;
        int step = 0;
        if (n >= 2){
            step++;
            int l = nums[0] + 0;
            int index = 0;
            while (index < n){
                if (l >= n-1)
                    return step;
                int tempMax = l;
                int i = index;
                while (i <= l){
                    if (nums[i]+i > tempMax){
                        tempMax = nums[i]+i;
                    }
                    i++;
                }
                index = l+1;
                l = tempMax;
                step++;
            }
        }
        return step;
    }
}
