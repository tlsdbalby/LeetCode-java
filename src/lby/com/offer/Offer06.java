package lby.com.offer;

import lby.com.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
* 剑指 Offer 06. 从尾到头打印链表
*   输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
* 解:
*   思路1:采用递归到尾节点,再开始加入
* */
public class Offer06 {
    public static void main(String[] args) {

    }

    public static int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        getNode(head, list);
        int[] re = new int[list.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = list.get(i);
        }
        return re;
    }

    public static void getNode(ListNode node, List<Integer> list){
        if (node != null){
            getNode(node.next, list);
            list.add(node.val);
        }
    }
}
