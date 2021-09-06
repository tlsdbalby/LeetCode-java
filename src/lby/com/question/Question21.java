package lby.com.question;

import lby.com.util.ListNode;

/*
* 21. 合并两个有序链表
*   将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
* 解:
*   思路1:双指针,遍历两个链表
*/
public class Question21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode re = new ListNode(-1, null);
        ListNode head = re;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (true){
            if (p1 == null){
                re.next = p2;
                break;
            } else if (p2 == null){
                re.next = p1;
                break;
            } else {
                if (p1.val > p2.val) {
                    re.next = p2;
                    p2 = p2.next;
                } else {
                    re.next = p1;
                    p1 = p1.next;
                }
                re = re.next;
            }
        }
        return head.next;
    }
}
