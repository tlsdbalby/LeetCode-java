package lby.com.bt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* 17. 电话号码的字母组合
*   给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
*   给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
* 解:
*   思路1:回溯法
*       1.确定递归参数及返回值: 当前字符串 当前数字
*       2.确定递归边界条件: 当字符串长度 == 目标长度
*       3.确定回溯搜索过程: 1.横向遍历: 当前数字所包含字母与curStr的每一种组合
*                       2.纵向递归: 下一个数字所包含的字母
*       注意: 本题不存在非法结果, 因此每个结果都要记录
*       剪枝思路1: 无需剪枝! 只要保证别访问越界即可
* */
public class Question17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        if (digits.equals(""))
            return null;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        hashMap.put(2, 97);
        hashMap.put(3, 100);
        hashMap.put(4, 103);
        hashMap.put(5, 106);
        hashMap.put(6, 109);
        hashMap.put(7, 112);
        hashMap.put(8, 116);
        hashMap.put(9, 119);
        char[] chars = digits.toCharArray();
        backTracking("", 0, chars, hashMap, list, chars.length);
        return list;
    }
    public static void backTracking(String curStr, int index, char[] chars, HashMap<Integer, Integer> hashMap, List<String> list, int k){
        if (curStr.length() == k){
            list.add(curStr);
            return;
        }
        if (index == k)
            return;
        int num = chars[index]-48;
        int start = hashMap.get(num);
        int l = (num == 7 || num == 9) ? 4 : 3;
        for (int i = start; i < start+l; i++) {
            backTracking(curStr+((char)(i)), index+1, chars, hashMap, list, k);
        }

    }

}
