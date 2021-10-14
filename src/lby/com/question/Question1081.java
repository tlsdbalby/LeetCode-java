package lby.com.question;

import java.util.Stack;

/*
* 1081. 不同字符的最小子序列
*   返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
* 解:
*   思路1:本题考察两点, 一是字符串的去重, 二是尽量保存字符串的字典序最小, 这意味着若是字母组合若存在多种字典序的可能, 则选取最小的
*       若是字母只出现一次, 则直接获取
*           主要逻辑: 1若当前栈为空, 则char直接入栈
*                        2若不为空, 若char比栈顶元素字典序小, 且char没出现的情况下, 入栈
*                                              3若字典序大, 若char已出现, 则跳过
*                                                         4若没出现, 则判断栈顶元素是否会在char之后出现, 若出现则将栈顶弹出, 回到1
*                                                                                                5若不出现则将char入栈
* */
public class Question1081 {
    public static void main(String[] args) {
        System.out.println(smallestSubsequence("cbaacabcaaccaacababa"));
    }
    public static String smallestSubsequence(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean[] isAdd = new boolean[26];
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            while (true){
                if (stack.isEmpty()){
                    stack.push(c);
                    isAdd[c-97] = true;
                    break;
                } else {
                    char top = stack.peek();
                    if (top == c)
                        break;
                    if (top < c){
                        if (!isAdd[c-97]){
                            stack.push(c);
                            isAdd[c-97] = true;
                        }
                        break;
                    } else {
                        if (isAdd[c-97])
                            break;
                        boolean isMore = false;
                        for (int j = i+1; j < chars.length; j++) {
                            if (chars[j] == top){
                                isMore = true;
                                break;
                            }
                        }
                        if (isMore){
                            stack.pop();
                            System.out.println("弹栈: " + top);
                            isAdd[top-97] = false;
                        } else {
                            if (!isAdd[c-97]){
                                stack.push(c);
                                isAdd[c-97] = true;
                            }
                            break;
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
