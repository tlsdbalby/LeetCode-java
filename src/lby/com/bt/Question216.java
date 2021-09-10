package lby.com.bt;

import java.util.ArrayList;
import java.util.List;

/*
* 216. 组合总和 III
*   找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
*   说明：所有数字都是正整数。解集不能包含重复的组合。 
* 解:
*   思路1:回溯法 暴力+剪枝找所有可能性
*       1.确定递归参数及返回值: 由于要 k个元素 计算元素和 且 元素不能重复, 所以参数要有 当前元素list 当前元素和 待选元素范围, 其他参数需要再补
*                           由于要记录每种合法组合, 所以需要外部集合保存合法结果, 无需返回值
*       2.确定递归边界条件: 当元素达到k个时, 若和 = n则记录, != n则pass
*       3.确定回溯搜索过程:1.横向遍历: 将当前可以选取的每个元素分别加入list
*                       2.纵向递归: 新list 新sum 和 缩小范围后的待选元素 进入递归
*       剪枝思路1: curSum > n 时 pass
*                剩余元素数量少于需要数量 pass
* */
public class Question216 {
    public static void main(String[] args) {
        for (List<Integer> list : combinationSum3(3, 7)) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        backTracking(n, 0, k, new ArrayList<>(), 1, lists);
        return lists;
    }

    public static void backTracking(int n, int curSum, int k, List<Integer> list, int lower, List<List<Integer>> lists){
        if (curSum > n)
            return;
        if (9 - lower + 1 < k - list.size())
            return;
        if (list.size() == k){
            if (curSum == n)
                lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = lower; i <= 9; i++) {
            list.add(i);
            backTracking(n, curSum+i, k, list, i+1, lists);
            list.remove(list.size()-1);
        }
    }
}
