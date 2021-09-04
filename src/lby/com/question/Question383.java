package lby.com.question;
/*
* 383. 赎金信
*   给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines
*   里面的字符构成。如果可以构成，返回 true ；否则返回 false。
*   (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
* 解
*   思路1:构建一个有小写英文字母数组int[26],然后将magazine字符串按照字符出现次数填充此数组,
*   再用ransom字符串去遍历数组并减减,若不出现-1则成功
* */
public class Question383 {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        char[] mc = magazine.toCharArray();
        for (char c : mc) {
            chars[c-'a']++;
        }
        char[] rc = ransomNote.toCharArray();
        for (char c : rc) {
            if (chars[c-'a'] == 0)
                return false;
            else chars[c-'a']--;
        }
        return true;
    }
}
