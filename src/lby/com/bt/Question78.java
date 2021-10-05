package lby.com.bt;

import java.util.ArrayList;
import java.util.List;

/*
* 78. 子集
*   给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
*   解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
* 解:
*   思路1:回溯法 本题可以简化成 在nums中寻找长度为1到nums.length 的子集, 因此对于回溯来说, 可以在最外层按照指定长度取回溯, 将结果合并即可
*       1.确定递归函数参数及返回值: 固定参数:nums, 结果集合lists. 可变参数: 本层递归nums的开始位置start, 剩余子集长度len, 当前结果list. 无需返回值
*       2.确定递归函数边界条件: len == 0
*       3.确定横向搜索过程: 从start开始遍历nums, 将每一个元素放入list, 进行下层递归, 然后回溯
*
*       更抽象的回溯: 无需最外层的长度设定, 每层递归时首先将当前结果加入结果集合, 然后遍历回溯即可, 只有当开始位置超出nums时才返回, 这样一来就是对整个回溯树的所有节点进行访问
*       1.确定递归函数参数及返回值: 固定参数:nums, 结果集合lists. 可变参数: 本层递归nums的开始位置start, 当前结果list. 无需返回值
*       2.确定递归函数边界条件: start == nums.length
*       3.确定横向搜索过程: 每层递归开始时, 现将当前结果加入结果集合, 然后从start开始遍历nums, 将每一个元素放入list, 进行下层递归, 然后回溯
*       注意: 每层递归开始先将当前结果放入结果集合 意味着 我们寻找的是回溯树的所有节点!! 之前的回溯问题都是寻找回溯树的合法叶子节点!! 这里的区别要明白!
* */
public class Question78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backTracking(nums, lists, 0, i, new ArrayList<>());
        }
        return lists;
    }
    public static void backTracking(int[] nums, List<List<Integer>> lists, int start, int len, List<Integer> list){
        if (len == 0){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backTracking(nums, lists, i+1, len-1, list);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backTracking2(nums, lists, 0, new ArrayList<>());
        return lists;
    }
    public static void backTracking2(int[] nums, List<List<Integer>> lists, int start, List<Integer> list){
        lists.add(new ArrayList<>(list));
        if (start == nums.length)
            return;
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backTracking2(nums, lists, i+1, list);
            list.remove(list.size() - 1);
        }
    }
}
