package lby.com.question;

import java.util.ArrayList;
import java.util.List;

/*
* 119. 杨辉三角 II
*   给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
*   在「杨辉三角」中，每个数是它左上方和右上方的数的和。
* 解:
*   思路1: 构建完整的杨辉三角,输出最后一层
 * */
public class Question119 {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        zero.add(1);
        if (rowIndex == 0)
            return zero;
        lists.add(zero);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> pre = lists.get(i-1);
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(pre.get(j-1)+pre.get(j));
            }
            list.add(1);
            lists.add(list);
        }
        return lists.get(rowIndex);
    }
}
