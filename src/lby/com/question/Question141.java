package lby.com.question;


import lby.com.util.ListNode;

import java.util.HashSet;

/*
* 141. 环形链表
*   给定一个链表，判断链表中是否有环。如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
*   为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
*   如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
*   如果链表中存在环，则返回 true 。 否则，返回 false 。
*   进阶：你能用 O(1)（即，常量）内存解决此问题吗？
*
* 解:
*   思路1:用HashSet将已遍历的节点存储,每次遍历新节点插入HashSet,通过插入成功与否判断是否存在环.
*   思路2:已知链表长度不超过10^4,因此可以使用计数,若是遍历次数超过10^4还没有结束,则认为有环
*   思路3:龟兔赛跑法(快慢指针).两个指针,p1每次+1,p2每次+2,若有全,则存在快指针跑到慢指针后面的情况!(p2.next == p1)
* */
public class Question141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        HashSet<Integer> hashSet = new HashSet<>();
        ListNode node = head;
        while (node != null){
            if (hashSet.add(node.hashCode()))
                node = node.next;
            else
                return true;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        for (int i = 0; i < 10001; i++) {
            if (head != null)
                head = head.next;
            else
                return true;
        }
        return false;
    }

    public boolean hasCycle3(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = p1;
        while (p1 != null){
            if (p1.next == p2)
                return true;
            else {
                if (p1.next == null)
                    return false;
                p1 = p1.next.next;
                p2 = p2.next;
            }
        }
        return false;
    }
}
