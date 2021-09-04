package lby.com.question;

import java.util.HashSet;
import java.util.List;

public class Question36 {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hashSet = new HashSet<>();
        char[] row;
        for (int i = 0; i < board.length; i++) {
            row = board[i];
            for (char c : row) {
                if (c == '.')
                    continue;
                if (!hashSet.contains(c))
                    hashSet.add(c);
                else{
                    System.out.println("row");
                    return false;
                }

            }
            hashSet.clear();
            for (int j = 0; j < row.length; j++) {
                Character c = board[j][i];
                if (c == '.')
                    continue;
                if (!hashSet.contains(c))
                    hashSet.add(c);
                else{
                    System.out.println("col");
                    return false;
                }
            }
            hashSet.clear();
        }
        int[] scale = {0, 3, 6};
        for (int i : scale) {
            for (int j : scale) {
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        Character c = board[k][l];
                        if (c == '.')
                            continue;
                        if (!hashSet.contains(c))
                            hashSet.add(c);
                        else{
                            System.out.println("block");
                            return false;
                        }
                    }
                }
                hashSet.clear();
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        HashSet<Character>[] hashSet = new HashSet[2];
        for (int i = 0; i < hashSet.length; i++) {
            hashSet[i] = new HashSet<>();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Character c1 = board[i][j];
                Character c2 = board[j][i];
                if (c1 != '.'){
                    if (!hashSet[0].contains(c1))
                        hashSet[0].add(c1);
                    else
                        return false;
                }
                if (c2 != '.'){
                    if (!hashSet[1].contains(c2))
                        hashSet[1].add(c2);
                    else
                        return false;
                }
            }
            hashSet[0].clear();
            hashSet[1].clear();
        }
        int[] scale = {0, 3, 6};
        for (int i : scale) {
            for (int j : scale) {
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        Character c = board[k][l];
                        if (c == '.')
                            continue;
                        if (!hashSet[0].contains(c))
                            hashSet[0].add(c);
                        else
                            return false;
                    }
                }
                hashSet[0].clear();
            }
        }
        return true;
    }
}
