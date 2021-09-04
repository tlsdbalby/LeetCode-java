package lby.com.question;

import java.util.ArrayList;
import java.util.List;

/*
* 706. 设计哈希映射
* */
public class Question706 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 3);
        System.out.println(list);
    }

    class MyHashMap{
        private ArrayList<Integer> keyList;
        private ArrayList<Integer> valueList;

        /** Initialize your data structure here. */
        public MyHashMap() {
            keyList = new ArrayList<>();
            valueList = new ArrayList<>();
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            if (keyList.size() > 0){
                for (int i = 0; i < keyList.size(); i++) {
                    if (keyList.get(i) == key){
                        valueList.remove(i);
                        valueList.add(i, value);
                        return;
                    }
                }
            }
            keyList.add(key);
            int index = keyList.size()-1;
            valueList.add(index, value);
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            for (int i = 0; i < keyList.size(); i++) {
                if (keyList.get(i) == key)
                    return valueList.get(i);
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            for (int i = 0; i < keyList.size(); i++) {
                if (keyList.get(i) == key){
                    keyList.remove(i);
                    valueList.remove(i);
                }
            }
        }
    }
}
