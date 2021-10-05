package lby.com.offer;

import lby.com.util.ListNode;

public class Offer24 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode point = head.next;
        head.next = null;
        ListNode pre = head;
        while (point != null){
            ListNode temp = point.next;
            point.next = pre;
            pre = point;
            point = temp;
        }
        return pre;
    }
}
