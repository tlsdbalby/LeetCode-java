package lby.com.offer;
/*
* 剑指 Offer 05. 替换空格
*   请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
* */
public class Offer05 {
    public static void main(String[] args) {

    }
    public String replaceSpace(String s) {
        StringBuilder strb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' '){
                strb.append("%20");
            } else strb.append(aChar);
        }
        return strb.toString();
    }
}
