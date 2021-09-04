package lby.com.question;

import java.util.ArrayList;
import java.util.List;
/*
* 118. 杨辉三角
*   给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
*   在「杨辉三角」中，每个数是它左上方和右上方的数的和。
* 解：
*   思路1：找出两层之间元素的下标关系即可，总体来说，每层首位元素都是1，中间元素j：本层[j] = 上层[j-1] + 上层[j]
*
* */
public class Question118 {
    public static void main(String[] args) {
        List<List<Integer>> re = generate(5);
        System.out.println(re);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0)
                list.add(1);
            else {
               List<Integer> preList = lists.get(i-1);
               list.add(1);
                for (int j = 1; j < i; j++) {
                    list.add(preList.get(j-1)+preList.get(j));
                }
                list.add(1);
            }
            lists.add(list);
        }

        return lists;
    }
}
