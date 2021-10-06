package lby.com.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
* 剑指 Offer 35. 复杂链表的复制
*   请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
*   还有一个 random 指针指向链表中的任意节点或者 null。
* 难点: 对于random属性来说, 无法在第一次遍历时就进行复制, 必须将原链表遍历一遍后才能得到所有节点的信息, 进而对random进行复制,
*   因此至少要遍历两次才可
* 解:
*   思路1: 第一次遍历: 建立新链表, 进行next复制, 并对原链表建立hashMap, 记录节点地址以及节点的绝对位置, 然后第二次遍历进行random复制
* */
public class Offer35 {
    public static void main(String[] args) {

    }
    public Node copyRandomList(Node head) {
        Node newChain = new Node(0);
        Node newHead = newChain;
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        HashMap<Node, Integer> hashMap = new HashMap<>();
        int index = 0;
        while (head != null){
            Node node = new Node(head.val);
            hashMap.put(head, index);
            list1.add(head.random);
            list2.add(node);
            newChain.next = node;
            newChain = newChain.next;
            head = head.next;
            index++;
        }
        newChain = newHead.next;
        index = 0;
        while (newChain != null){
            Node temp = list1.get(index);
            if (temp != null){
                newChain.random = list2.get(hashMap.get(temp));
            } else {
                newChain.random = null;
            }
            newChain = newChain.next;
            index++;
        }
        return newHead.next;
    }

    class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
