package lby.com.offer;
/*
* 剑指 Offer 50. 第一个只出现一次的字符
*   在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
* 条件提取: s只包含小写字母, 即s最多有26个字符可能性
* 解:
*   思路1: 创建一个长度为26的数组, 元素是某个字符出现的频率, 首先第一次遍历s填充此数组, 然后第二次遍历s, 从数组中找第一个为频率为1的字符,
*       注意数组的遍历顺序应该是字符串的字符顺序(即第二次遍历), 而不是下标递增顺序!
* */
public class Offer50 {
    public static void main(String[] args) {

    }
    public char firstUniqChar(String s) {
        short[] nums = new short[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            nums[aChar - 97]++;
        }
        for (char aChar : chars) {
            if (nums[aChar - 97] == 1)
                return aChar;
        }
        return ' ';
    }
}
