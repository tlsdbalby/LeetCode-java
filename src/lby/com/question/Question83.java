package lby.com.question;

import lby.com.util.ListNode;

import java.util.HashSet;

/*
* 83. 删除排序链表中的重复元素
*   存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次
*   返回同样按升序排列的结果链表。
* 解:
*   思路1:将已遍历过的节点的值存到hashSet中,每次到新节点,查询hashSet中是否已有此值,hashSet查询为O(1)
*   思路2:因为链表本身是升序的,所以相同值一定是在一起的,可以连续判断是否为重复值,若是则跳过,若不是则指针前移并改变候选值
* */
public class Question83 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> hashSet = new HashSet<>();
        ListNode p = new ListNode(0, head);
        ListNode re = p;
        while (p.next != null){
            if (hashSet.add(p.next.val))
                p = p.next;
            else
                p.next = p.next.next;
        }
        return re.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null)
            return null;
        ListNode re = new ListNode(0, head);
        ListNode p = head;
        int sign = head.val;
        while (p.next != null) {
            if (p.next.val == sign) {
                p.next = p.next.next;
            } else {
                p = p.next;
                sign = p.val;
            }
        }
        return head;
    }
}
