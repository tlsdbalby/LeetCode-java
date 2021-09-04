package lby.com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
* 在for循环中删除指定元素
*   因为ArrayList底层时数组，所以删除元素i需将i之后的所有元素向前移动一位，所以倒序删除速度会很快！
*   1、倒序删除 可用
*   2、正序删除 不可用！ 如下例所示，连续的两个应被删除元素在一起，只能删掉一个，因为删第一个会导致后面的前移，并且i++了，因此就漏了一个
*   3、迭代器删除 可用
*   4、foreach删除 不可用！ 会报错
* */
public class ForWithRemove {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 5, 6, 6));
//        for (int i = 0; i < 100000; i++) {
//            list.add(i);
//        }
        System.out.println(System.currentTimeMillis());
        System.out.println("倒删：" + removeMethod1(list));
        System.out.println(System.currentTimeMillis());
        System.out.println("正删：" + removeMethod2(list));
        System.out.println(System.currentTimeMillis());
        System.out.println("迭代器删：" + removeMethod3(list));
        System.out.println(System.currentTimeMillis());
//        System.out.println("foreach删：" + removeMethod4(list));会出错！
    }

    static List<Integer> removeMethod1(ArrayList<Integer> list){
        ArrayList<Integer> l = (ArrayList<Integer>) list.clone();
        for (int i = l.size() - 1; i >= 0; i--) {
            if (l.get(i) % 2 == 0)
                l.remove(i);
        }
        return l;
    }

    static List<Integer> removeMethod2(ArrayList<Integer> list){
        ArrayList<Integer> l = (ArrayList<Integer>) list.clone();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) % 2 == 0)
                l.remove(i);
        }
        return l;
    }

    static List<Integer> removeMethod3(ArrayList<Integer> list){
        ArrayList<Integer> l = (ArrayList<Integer>) list.clone();
        for (Iterator<Integer> iterator = l.iterator(); iterator.hasNext();){
            if (iterator.next() % 2 == 0)
                iterator.remove();
        }
        return l;
    }


    static List<Integer> removeMethod4(ArrayList<Integer> list){
        ArrayList<Integer> l = (ArrayList<Integer>) list.clone();
        for (Integer integer : l) {
            if (integer % 2 == 0)
                l.remove(integer);
        }
        return l;
    }
}
