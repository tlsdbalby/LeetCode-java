package lby.com.question;

import java.util.*;

/*
* 56. 合并区间
*   以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
*   请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
*   注意: 区间是无序的
* 解:
*   思路1: 相邻合并
* */
public class Question56 {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            int[] cur = intervals[i];
            if (cur[1] >= intervals[i+1][0] && cur[0] <= intervals[i+1][1]){
                if (cur[1] > intervals[i+1][1])
                    intervals[i+1][1] = cur[1];
                if (cur[0] < intervals[i+1][0])
                    intervals[i+1][0] = cur[0];
            } else {
                indexList.add(i);
            }
        }
        indexList.add(n-1);
        int[][] re = new int[indexList.size()][2];
        for (int i = 0; i < indexList.size(); i++) {
            re[i][0] = intervals[indexList.get(i)][0];
            re[i][1] = intervals[indexList.get(i)][1];
        }
        return re;
    }

    public int[][] merge2(int[][] intervals) {
        boolean[] maxL = new boolean[10000];
        HashSet<Integer> oneSet = new HashSet<>();
        int maxUpper = -1;
        for (int[] interval : intervals) {
            int lower = interval[0];
            int upper = interval[1];
            if (upper > maxUpper)
                maxUpper = upper;
            if (lower == upper)
                oneSet.add(lower);
            for (int j = lower; j < upper; j++){
                maxL[j] = true;
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < maxUpper; i++) {
            if (maxL[i]){
                int j = i;
                for ( ; j <= maxUpper; j++) {
                    if (!maxL[j])
                        break;
                }
                int[] t = {i, j};
                list.add(t);
                i = j;
            }
        }
        List<Integer> one = new ArrayList<>(oneSet);
        for (int[] ints : list) {
            for (int j = one.size() - 1; j >= 0; j--) {
                int integer = one.get(j);
                if (ints[0] <= integer && ints[1] >= integer)
                    one.remove(j);
            }
        }
        int l = list.size();
        int[][] re = new int[l+one.size()][2];
        for (int i = 0; i < l; i++) {
            re[i] = list.get(i);
        }
        for (int i = 0; i < one.size(); i++) {
            re[l+i] = new int[]{one.get(i), one.get(i)};
        }
        return re;
    }
}
