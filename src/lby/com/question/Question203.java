package lby.com.question;


import lby.com.util.ListNode;

/*
* 203. 移除链表元素
*   给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
* 解:
*   思路1:单指针p删除,若p.next是目标节点，则删除(p.next = p.next.next),但是指针不前移,若不是目标节点,则指针前移(p = p.next)
* 注:
*   做指针的题一定要画图!!
* */
public class Question203 {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode re = new ListNode(0, head);
        ListNode nHead = re;
        while (re.next != null){
            if (re.next.val == val)
                re.next = re.next.next;
            else
                re = re.next;
        }
        return nHead.next;
    }
}
