package lby.com.tencent;

import lby.com.util.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
*
* */
public class Main {
    public static void main(String[] args) {

    }

    public static ListNode solve(ListNode[] a){
        ListNode point = new ListNode(-1);
        ListNode re = point;
        int n = a.length;
        boolean[] sign = new boolean[n];
        short voidList = 0;
        while (voidList < n){
            for (short i = 0; i < n; i++) {
                if (a[i] == null){
                    if (!sign[i]){
                        voidList++;
                        sign[i] = true;
                    }
                } else {
                    point.next = a[i];
                    point = point.next;
                    a[i] = a[i].next;
                }
            }
        }
        return re.next;
    }
}
