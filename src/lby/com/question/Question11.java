package lby.com.question;
/*
* 11. 盛最多水的容器
*   给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
*   在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
*   找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。说明：你不能倾斜容器。
* 条件提取:画图较为直观!
* 解:
*   思路1:双层for循环+剪枝, 找每种容器边缘的组合, 从中选取最大值, 利用一些特性进行剪枝. 效率低, 而且要处理特殊情况 O(n^2)
*   思路2:双指针, 基于: 容器两个边缘, 短的那个限制存储容量, 因此改变短边一定会改变容量!. 这一理念, 每次只变换短边, 直到两边重合,
*       因此只要遍历一遍即可! O(n)
* */
public class Question11 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int max = 0;
        int p1 = 0;
        int p2 = height.length - 1;
        while (p1 != p2){
            max = Math.max(max, Math.min(height[p1], height[p2])*(p2 - p1));
            if (height[p1] <= height[p2])
                p1++;
            else p2--;
        }
        return max;
    }
}
