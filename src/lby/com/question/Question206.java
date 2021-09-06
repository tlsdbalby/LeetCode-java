package lby.com.question;


import lby.com.util.ListNode;

/*
* 206. 反转链表
*   给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
* 解：
*   思路1:回溯法用递归实现
*       边界条件:下一个节点为null(即找到链表尾节点)
*       迭代条件:下一节点不为null
*       附加操作(必有):翻转前后两个节点的指向关系
*       注意:因为要翻转指向,所以要把这把部分放到最后做,否则就破坏了链表原来的连接关系,无法遍历
* */
public class Question206 {
    ListNode nHead;
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        it(head, null);
        return nHead;
    }

    public void it(ListNode now, ListNode pre){
        //找到尾节点，作为新的头结点
        if (now.next != null)
            it(now.next, now);
        else
            nHead = now;
        //翻转前后两个节点的指向关系
        now.next = pre;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = null;
        while (p1 != null){
            ListNode cur = p1.next;
            p1.next = p2;
            p2 = p1;
            p1 = cur;
        }
        return p2;
    }
}
