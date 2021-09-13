package lby.com.question;

import java.util.PriorityQueue;
import java.util.Queue;

/*
* LCP 30. 魔塔游戏
*   小扣当前位于魔塔游戏第一层，共有 N 个房间，编号为 0 ~ N-1。每个房间的补血道具/怪物对于血量影响记于数组 nums，其中正数表示道具补血数值，
*   即血量增加对应数值；负数表示怪物造成伤害值，即血量减少对应数值；0 表示房间对血量无影响。
*   小扣初始血量为 1，且无上限。假定小扣原计划按房间编号升序访问所有房间补血/打怪，为保证血量始终为正值，
*   小扣需对房间访问顺序进行调整，每次仅能将一个怪物房间（负数的房间）调整至访问顺序末尾。请返回小扣最少需要调整几次，
*   才能顺利访问所有房间。若调整顺序也无法访问完全部房间，请返回 -1。
* 解:
*   思路1:前缀和 + 最大负值调整, 遍历计算签字和, 当前缀和为负时, 将此时最大的负值移动到数组末尾, 数组上限--, 前缀和+=1最大负值,
*       需要一个集合记录最大的负值, 每次取出后自动更新, 因此推荐优先队列
* */
public class LCP30 {
    public static void main(String[] args) {
        int[] nums = {100,100,100,-250,-60,-140,-50,-50,100,150};
        System.out.println(magicTower(nums));
    }
    public static int magicTower(int[] nums) {
        //全正值和 + 1 > 全负值和 才有解
        int sum = 1;
        for (int num : nums) {
            sum += num;
        }
        if (sum > 0){
            int upper = nums.length;
            long s = 1;
            //优先级队列 默认是小顶堆
            Queue<Integer> priority = new PriorityQueue<>();
            int times = 0;
            for (int num : nums) {
                s = s + num;
                if (num < 0){
                    priority.add(num);
                }
                if (s <= 0){
                    Integer t = priority.poll();
                    if (t != null){
                        //将最小的负值再补回来, 约等于将这个值移到末尾, 不参与当计算
                        s += -t;
                    }
                    times++;
                }
            }
            return times;
        }
        return -1;
    }
}
