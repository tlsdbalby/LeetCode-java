package lby.com.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
* 49. 字母异位词分组
*   给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
*   字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
* 解:
*   思路1:将字符串数组strs复制一份的copy, 将copy中的每个字符串的字符进行排序, 使得具有相同字符的字符串相等,
*   然后利用strs与copy相同位置指代同一个元素的特性, 记录copy中相同字符串的位置然后去strs取得即可
* */
public class Question49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams2(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        String[] copy = Arrays.copyOf(strs, strs.length);
        for (int i = 0; i < copy.length; i++) {
            String str = copy[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            copy[i] = new String(chars);
        }
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            String str = copy[i];
            if (hashMap.containsKey(str))
                hashMap.get(str).add(strs[i]);
            else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hashMap.put(str, list);
            }
        }
        for (String s : hashMap.keySet()) {
            lists.add(hashMap.get(s));
        }
        return lists;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (hashMap.containsKey(key))
                hashMap.get(key).add(str);
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(key, list);
            }
        }
        for (String s : hashMap.keySet()) {
            lists.add(hashMap.get(s));
        }
        return lists;
    }
}
