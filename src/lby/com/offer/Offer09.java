package lby.com.offer;

import java.util.Stack;

/*
* 剑指offer09
*   用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
*   分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
*
* 解:
*   思路1:双栈, in栈存放入队数据, out栈存放出队数据, 工作逻辑: 当入队时, 将数据存入in栈,
*       当头元素出队时, 判断out栈是否为空, 若不为空则取out栈栈顶, 若为空则将in栈按序弹入out栈, 再取栈顶
* */
public class Offer09 {
    public static void main(String[] args) {

    }
    class CQueue {
        Stack<Integer> in;
        Stack<Integer> out;
        public CQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {
            if (out.isEmpty()){
                if (in.isEmpty())
                    return -1;
                while (!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.pop();
        }
    }
}
