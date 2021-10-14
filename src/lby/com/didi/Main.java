package lby.com.didi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Double> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(sc.nextDouble());
        }
        System.out.println(hashSet.size());
    }
}
