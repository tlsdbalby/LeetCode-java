package lby.com.offer;
/*
* 剑指 Offer 58 - II. 左旋转字符串
*   字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
*   比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
* 解:
*   思路1:左旋转其实就是将左边的一部分移到右边, 因此可以将字符串复制成两份, 两份头尾相接, 然后按照下标取出即可,
*       例如abc左旋2, abcacb, 取下标2到2+length的子串即可
* */
public class Offer58 {
    public static void main(String[] args) {

    }
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        if (n >= len)
            n = n % len;
        if (n == 0)
            return s;
        else {
            String doubleStr = s + s;
            return doubleStr.substring(n, n + len);
        }
    }
}
