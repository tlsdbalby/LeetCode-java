package lby.com.bt;

import java.util.ArrayList;
import java.util.List;

/*
* 131. 分割回文串
*   给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
*   回文串 是正着读和反着读都一样的字符串。
* 解:
*   思路1:回溯法, 主要是如何分割, 回文判断较为简单
*       1.确定递归函数参数及返回值: 固定参数:原字符串数组chars, 结果集合lists. 变化参数:当前递归下chars的开始位置s, 结果集合list
*       2.确定递归函数边界条件: 当s超出chars的末尾即 s == chars.length
*       3.确定横向搜索过程: 从当前开始位置s开始, 遍历每一种分割长度进行回溯操作
*   注意:这道题的难点在于, 如何分割字符串, 用回溯树来分割, 每次根据长度分割, 核心还是横向搜索可能的选项情况, 纵向组合最终结果!
*       其实这个分割问题也可转化成组合问题, 回溯法善于解决组合问题!
* */
public class Question131 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
    public static List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        List<List<String>> lists = new ArrayList<>();
        backTracking(chars, lists, 0, new ArrayList<String>());
        return lists;
    }

    public static void backTracking(char[] chars, List<List<String>> lists, int start, List<String> list){
        if (start == chars.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        StringBuilder strB = new StringBuilder();
        for (int i = start; i < chars.length; i++) {
            strB.append(chars[i]);
            String str = strB.toString();
            if (isHW(str)){
                list.add(str);
                backTracking(chars, lists, i+1, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public static boolean isHW(String str){
        if (str.length() == 1)
            return true;
        char[] cs = str.toCharArray();
        int len = str.length();
        int mid = len / 2;
        for (int i = 0; i < mid; i++) {
            if (cs[i] != cs[len-1-i])
                return false;
        }
        return true;
    }
}
