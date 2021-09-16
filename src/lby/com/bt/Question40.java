package lby.com.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 40. 组合总和 II
*   给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
*   candidates 中的每个数字在每个组合中只能使用一次。注意：解集不能包含重复的组合。
* 解:
*   思路1:回溯+剪枝
*       回溯 注意candidates中有重复元素
*       1.确定递归函数参数及返回值: 固定参数:候选集合candidates, 结果集合lists. 变化参数:本层递归candidates开始位置s, 当前与target的差值des, 当前已选元素集合list
*                               无需返回值
*       2.确定递归边界条件: des == 0 时找到合法组合
*       3.确定每层搜索过程: 由于存在重复元素, 且结果集中不能包含重复结果, 因此当遇到重复元素时不能逐个遍历, 而需要跳位, 即在每层搜索时去重
*       剪枝
*       起始时将candidates排序(这一步很重要, 也关系到避免重复结果的跳位!), 基于candidates的非负性, 若当前元素大于des, 则当前以及之后都不存在合法组合
*
*    拓展:回溯法中的重复分为两种 1.结果中的元素不能出现重复 2.结果与结果不能重复, 对于这两种重复, 可以从回溯树入手, 区分二者是如何产生, 怎样可以避免的
*       以本题为背景, candidates=[1,1,1,2,3] target=3 画图即可
*       1.结果中的重复元素是在纵向递归产生的, 因为对于回溯树来说, 从根节点到叶节点的一条路径构成了一个结果,
*           因此结果中的重复元素是在纵向递归过程中加入了重复元素
*       2.结果与结果的重复, 这个较为复杂, 即牵扯到纵向又牵扯到横向, 但归根到底可以发现, 结果的重复是由于在横向搜索过程中,
*           对于重复元素依然遍历而造成的, 若是在横向搜索过程中跳过重复元素, 则不会构造出重复结果
*       由此解决重复的方法, 重点在于如何对后续元素的选择, 此时对候选元素集合进行排序就是至关重要的了(不排序也行, 但会浪费空间, 例如可以用hashmap保持<元素,频率>)
*       当候选元素集合有序时, 意味着相同元素是相邻的, 可以通过下标的变化避免访问重复元素
*       对于1型重复, 可以使下层递归的候选元素集合的开始位置跳到下一个不重复元素(纵向递归跳位)
*       对于2型重复, 可以使本层搜索过程中, 只操作重复元素中的第一个, 然后跳到下一个不重复元素(横向搜索, 循环内跳位)
* */
public class Question40 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (cur > des)
                break;
            //找到本元素重复元素的最后一个元素的下标
            int j = i;
            boolean isSeem = false;
            while (j+1 < candidates.length){
                if (candidates[j+1] == cur){
                    isSeem = true;
                    j++;
                } else break;
            }
            list.add(cur);
            backTracking(candidates, lists, i+1, des-cur, list);
            list.remove(list.size() - 1);
            //跳到本元素重复元素的最后一个(因为for中还有i++, 因此此处不能跳到j+1)
            if (isSeem)
                i = j;
        }
    }
}
