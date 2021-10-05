package lby.com.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 39. 组合总和
*   给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
*   candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
*   对于给定的输入，保证和为 target 的唯一组合数少于 150 个
* 解:
*   思路1:回溯法+剪枝
*       回溯 无重复很关键！
*       1.确定递归函数参数及返回值: 对于本题来说, 固定参数:candidates, 结果集合lists. 变化参数:本层递归的candidates起始位置s, 本层递归与target的差距des, 已选择元素的集合list
*                               无需返回值
*       2.确定递归边界条件: des==0 找到一个合法组合
*       3.确定每层横向搜索过程: 起始位置不+1, 下层递归按照当层开始位置继续, 遍历candidates集合
*       剪枝
*       起始时将candidates排序, 基于其非负性和无重复, 可以得到如下判断: 当某层遍历搜索时, 若候选元素e > des, 则意味着当前位置及后续位置都不可能存在合法组合
* */
public class Question39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        System.out.println(combinationSum(candidates, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(candidates, lists, 0, target, new ArrayList<Integer>());
        return lists;
    }
    public static void backTracking(int[] candidates, List<List<Integer>> lists, int start, int des, List<Integer> list){
        if (des == 0){
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int cur = candidates[i];
            //剪枝, 基于candidates非负且排序后, 若当前元素已经大于差距des, 则后续肯定不存在合法组合
            if (cur > des)
                break;
            list.add(cur);//放入元素
            backTracking(candidates, lists, i, des-cur, list);
            list.remove(list.size()-1);//回溯本次操作
        }
    }
}
