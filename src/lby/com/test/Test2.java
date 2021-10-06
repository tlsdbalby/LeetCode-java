package lby.com.test;

import lby.com.util.ListNode;

public class Test2 {
    public static void main(String[] args) {
        myHash hashMap = new myHash();
        hashMap.put(1, 2);
        System.out.println(hashMap.get(1));
        hashMap.put(1, 3);
        System.out.println(hashMap.get(1));
        hashMap.put(9, 4);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(9));
        System.out.println();
    }
    static class myListNode{
        int key;
        int value;
        public myListNode next;

        public myListNode(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        public myListNode(int key, int value, myListNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    static class myHash{
        int len = 8;
        myListNode[] listNodes = new myListNode[len];

        public void put(Integer key, Integer value){
            int index = key % len;
            if (listNodes[index] == null){
                listNodes[index] = new myListNode(key, value);
            } else {
                myListNode node = listNodes[index];
                while (node != null){
                    if (node.key == key){
                        node.value = value;
                        return;
                    } else node = node.next;
                }
                listNodes[index] = new myListNode(key, value, listNodes[index]);
            }
        }

        public Integer get(Integer key){
            int index = key % len;
            myListNode node = listNodes[index];
            while (node != null){
                if (node.key == key){
                    return node.value;
                } else node = node.next;
            }
            return null;
        }
    }
}
