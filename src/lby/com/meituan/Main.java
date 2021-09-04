package lby.com.meituan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        short[] ap = new short[n];
        for (int i = 0; i < n; i++) {
            ap[i] = sc.nextShort();
        }
        if (n < 2)
            System.out.println(0);
        else {
            int sumAp = 0;

            HashMap<Short, Integer> lastIndex = new HashMap<>();
            HashMap<Short, HashSet<Short>> lastSum = new HashMap<>();
            for (int i = 1; i < n; i++) {
                HashSet<Short> hashSet = new HashSet<>();
                Short e = ap[i];
                int index = 0;
                if (lastIndex.containsKey(e)){
                    index = lastIndex.get(e);
                    hashSet = lastSum.get(e);
                }
                for (int j = index; j < i; j++) {
                    if (ap[i] > ap[j])
                        hashSet.add(ap[j]);
                }
                sumAp += hashSet.size();
                lastIndex.put(e, i);
                lastSum.put(e, hashSet);
            }
            System.out.println(sumAp);
        }
    }
}
