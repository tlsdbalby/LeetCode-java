package lby.com.question;

import java.util.Stack;
/*
* 20. 有效的括号
*   给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
*   有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合
* 解:
*   思路1:用stack,遍历字符串,遇到左括号则进栈,遇到右括号则弹栈,进行合法匹配,一错全错,全对则对
* */
public class Question20 {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.size() == 0)
                    return false;
                char r = stack.pop();
                int dec = c - r;
                if (!(dec == 1 || dec == 2))
                    return false;
            }
        }
        return stack.size()==0;
    }
}
