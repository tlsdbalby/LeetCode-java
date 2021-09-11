package lby.com.baidu;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        short n = sc.nextShort();
        short k = sc.nextShort();
        short[][] color = new short[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                color[i][j] = sc.nextShort();
            }
        }
        short i1 = 0;
        while (i1 < n){
            for (int l = 0; l < k; l++) {
                for (int i = 0; i < color[i1].length; i++) {
                    for (int j = 0; j < k; j++) {
                        System.out.print(color[i1][i]+" ");
                    }
                }
                System.out.println();
            }
            i1++;
        }
    }
}
