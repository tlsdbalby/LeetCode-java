package lby.com.bt;

import java.util.*;

/*
* 491. 递增子序列
*   给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
*   数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
* 解:
*   思路1:回溯+剪枝(其实没用到啥剪枝。。。)
*       1.确定递归函数参数及返回值: 固定参数:nums, 结果集合lists 变化参数: 本层递归nums的开始位置start, 结果长度len, 上个数last, 结果list. 无需返回值
*       2.确定递归函数的边界条件: start == nums.length
*       3.确定横向搜索过程: 因为结果集合中不允许出现重复结果, 因此需要在横向搜索过程中跳位, 只操作重复元素的第一个
*       这道题求的是深度>=2的所有节点, 因此add 与 return 分离, 虽然需要跳位, 但根据题意不可对nums排序！
*       因此需要加一个set, 记录本层递归的横向搜索过程中这个元素是否遇到过, 遇到则跳过!
*
*   总结:为了在结果集合中不出现重复结果, 必须在横向搜索过程(遍历)中进行跳位, 即对于有重复的元素, 只操作第一个, 跳过剩余重复元素
*       可能会面临两种情况:
*           1.原数组arr允许排序时(这要看题意), 将arr排序后(重复值会相邻, 可以一口气跳过), 在横向搜索的for循环中先进行一次回溯(操作重复值中的第一个),
*               然后进行重复判断, 跳过重复值(i值更新时要考虑到for循环的自增), 进入下一次循环. 参考Question40中的方式, while循环到最后一个
*               先回溯 后判断重复-去重
*           2.原数组arr不允许排序时, 例如本题!, 则在横向搜索的for循环中, 利用set来记录已经访问过的元素e,
*               若e在set中(set.contains(e)==true)则continue, 反之则将e加入set(下次判断就返回true!), 并且判断要放在回溯操作前!
*               先判断重复-去重 回溯
*
*           其实第二种方法可以代替第一种, 但由于第二种方法会在每层递归中创建HashSet, 所以消耗较大, 在回溯树深度较大时, 会造成浪费
*
*
* */
public class Question491 {
    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        System.out.println(findSubsequences(nums));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backTracking(nums, lists, 0, 0, -101, new ArrayList<>());
        return lists;
    }
    public static void backTracking(int[] nums, List<List<Integer>> lists, int start, int len, int last, List<Integer> list){
        if (len > 1) lists.add(new ArrayList<>(list));

        if (start == nums.length) return;

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            int n = nums[i];
            if (!hashSet.contains(n))
                hashSet.add(n);
            else
                continue;
            if (n >= last){
                list.add(nums[i]);
                backTracking(nums, lists, i+1, len+1, n, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
