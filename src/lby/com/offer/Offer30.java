package lby.com.offer;

import java.util.Stack;

/*
* 剑指 Offer 30. 包含min函数的栈
*   定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
* 解:
*   思路1:自己没想出来...看了官解,简直是米奇去了妙妙屋, 妙呀; 除了正常栈a之外再维护一个非严格降序栈b, 栈里的元素是降序的(底大上小),
*       但并不要求每一个入a的也要入栈b, 只入栈<=当前b栈顶元素的元素. 分析:借助栈本身元素的存放特点, 例如入栈 4 5 2 3, 理论上此时2是最小值,
*       3是次小值, 但实际情况, b中: 4 2, 并没有3, 因为2出栈时 3肯定也出去了!
* */
public class Offer30 {
    public static void main(String[] args) {

    }

    class MinStack {
        Stack<Integer> s1;
        Stack<Integer> s2;

        /** initialize your data structure here. */
        public MinStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
            if(!s2.isEmpty()){
                if (x <= s2.peek())
                    s2.push(x);
            } else {
                s2.push(x);
            }
        }

        public void pop() {
            if (!s1.isEmpty()){
                int e = s1.pop();
                if (!s2.isEmpty())
                    if (s2.peek() == e)
                        s2.pop();
            }
        }

        public int top() {
            if (!s1.isEmpty())
                return s1.peek();
            return -1;
        }

        public int min() {
            if (!s2.isEmpty())
                return s2.peek();
            return -1;
        }
    }
}
