package lby.com.bt;

import java.util.ArrayList;
import java.util.List;

/*
* 77. 组合
*   给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。你可以按 任何顺序 返回答案。
* 解:
*   思路1:回溯法, 此题是回溯法的经典题目, 按照模板三部曲进行
*       1.确定递归函数的参数及返回值: 对于每一层递归, 伴随着的是问题规模的缩小, 因此取值范围是必要的参数, 且每层递归都要缩小
*                               因为要记录的是每种可能性的具体情况, 因此需要一个外部集合保存合法结果, 无需返回值
*       2.确定递归边界条件: 当取够k个数时, 即找到了一种组合, 因此保存这个组合, 并终止本次递归
*       3.确定每层递归过程: 包含两个部分: 1.横向搜索过程: 在当前的范围内, 遍历找出每一种合法值加入组合
*                                   2.纵向递归过程: 将本层组合结果 以及 缩小的范围传递到下一层递归
*
*       由于回溯法本身是一种暴力解法(穷举出所有可能, 把合法的记录, 不合法的pass), 因此如果完全遍历则开销极大, 所有回溯法往往伴随着剪枝!
*       好的/合理的剪枝可以让回溯法起死回生!!
*       本题剪枝思路1: 当进入本层递归时发现剩余数字的数量少于需要的数量, 则肯定不可能有合法组合(因为数量不足), 所以可以直接return,
*           本剪枝可以提升8倍的性能!!
*       注意:回溯算法的回溯体现在: 每次选择元素e并计算后, 要弹出这个元素e, 回退到未选择的状态, 进而重新选择下一种可能!!
*
* */
public class Question77 {
    public static void main(String[] args) {
        for (List<Integer> list : combine(4, 2)) {
            System.out.println(list);
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        backTracking(1, n, k, new ArrayList<>(), lists);
        return lists;
    }

    private static void backTracking(int s, int e, int k, List<Integer> list, List<List<Integer>> lists){
        if (list.size() == k){
            lists.add(new ArrayList<>(list));//因为回溯的缘故, 所以此处若是add(list)则无法获取任何结果(因为list对象最终会变成[], 终结状态回溯为初始状态!) 所以要实例化一个新对象并将list元素拷贝进去才可!
            return;
        }
        if (e - s + 1 < k - list.size())
            return;
        for (int i = s; i <= e; i++) {
            list.add(i);
            backTracking(i+1, e, k, list, lists);
            list.remove(list.size()-1);//这一步就是"回溯"的来源, 将本次操作回退!!
        }
    }
}
