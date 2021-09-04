package lby.com.question;

import java.util.Arrays;
/*
* 455. 分发饼干
*   假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
*   对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，
*   都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
*   你的目标是尽可能满足越多数量的孩子，并输出这个最大数值
* 解:
*   思路1: 贪心法, 因为饼干大小必须大于小孩的胃口, 大饼干喂给大胃口, 即饼干喂给第一个小于等于它的胃口(贪心策略)
*       先对胃口和饼干排序, 然后从后向前,依次判断, 双指针标记二者下标
* */
public class Question455 {
    public static void main(String[] args) {

    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = g.length-1;
        int num = 0;
        for (int ng = s.length-1; ng >= 0;) {
            if (index < 0)
                break;
            //若是饼干可以喂给当前胃口, 饼干前移
            if (s[ng] >= g[index]){
                ng--;
                num++;
            }
            //无论是否喂给, 胃口前移
            index--;
        }
        return num;
    }
}
