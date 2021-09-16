package lby.com.bt;

import java.util.ArrayList;
import java.util.List;

/*
* 93. 复原 IP 地址
*   给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
*   有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
*   例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
*   和 "192.168@1.1" 是 无效 IP 地址。
* 解:
*   思路1:回溯+剪枝, 这道题本质是用四个点"."去分割这个数字字符串, 看结果是否是合法的IP地址
*       1.确定递归函数参数及返回值: 固定参数:数字字符串的数组chars, 结果集合list. 变化参数:本层递归chars的开始位置start,
*           还要分割几次times, 结果str. 无需返回值
*       2.确定递归函数的边界条件: 分割次数times==0, 开始位置starts==chars.length
*       3.确定横向搜索过程: 从start开始, 遍历每种一个"."可以分割剩余字符串的可能, 即每层确定一个"."的位置,
*           由于IP地址每段最大长度为3, 因此最多有3中可能
*       由于回溯会暴力搜所有可能, 且IP地址是比较特殊的形式, 因此这道题必须剪枝, 保证正确结果且降低开销
*   注意:这种字符串组合问题一定要用StringBuilder, 可以提高效率!
* */
public class Question93 {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("101023"));
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        backTracking(chars, list, 0, 4, "");
        return list;
    }
    public static void backTracking(char[] chars, List<String> list, int start, int times, String str){
        if (times == 0){
            if (start == chars.length)
                list.add(str.substring(0, str.length()-1));
            return;
        }
        if (start == chars.length) return;
        StringBuilder strB = new StringBuilder();
        int len = 0;
        for (int i = start; i < chars.length && len < 3; i++) {
            strB.append(chars[i]);
            len++;
            if (len == 3){
                int temp = Integer.valueOf(strB.toString());
                if (temp > 255)
                    break;
            }
            String newStr = str + strB + '.';
            backTracking(chars, list, i+1, times-1, newStr);
            if (chars[start] == '0')
                break;
        }
    }
}
