package lby.com.question;

import java.util.HashSet;

public class Question73 {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

    }
    public static void setZeroes(int[][] matrix) {
        HashSet<Integer> zeroR = new HashSet<>();
        HashSet<Integer> zeroC = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0){
                    zeroR.add(i);
                    zeroC.add(j);
                }
            }
        }
        for (Integer r : zeroR) {
            for (int i = 0; i < matrix[r].length; i++) {
                matrix[r][i] = 0;
            }
        }
        for (Integer c : zeroC) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
