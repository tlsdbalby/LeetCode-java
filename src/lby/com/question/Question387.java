package lby.com.question;

import java.util.LinkedHashMap;

/*
* 387. 字符串中的第一个唯一字符
*   给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
* 解：
*   思路1:用LinkedHashMap保存<字符,下标>若存在重复字符则更新为<字符,-1>,然后遍历这个map找到第一个value不为-1的字符
*
*   思路2:用字符的ASCII码性质,创建一个26长度的数组,对每个可能的字符出现次数进行计数,然后找第一个计数为1的字符,
*   巧妙的地方是如何找第一个,在找的时候要按照字符串的顺序进行遍历而不是数组的顺序!
* */
public class Question387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar2("loveleetcode"));
    }

    public static int firstUniqChar1(String s) {
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (hashMap.containsKey(c)){
                hashMap.put(c, -1);
            } else {
                hashMap.put(c, i);
            }
        }
        for (Character character : hashMap.keySet()) {
            if (hashMap.get(character) != -1)
                return hashMap.get(character);
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c-'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (count[c-'a'] == 1)
                return i;
        }
        return -1;
    }
}
