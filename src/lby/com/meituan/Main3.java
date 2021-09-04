package lby.com.meituan;

import java.util.HashSet;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String m = sc.nextLine();
        char[] sChars = s.toCharArray();
        char[] mChars = m.toCharArray();
        HashSet<Character> set = new HashSet<>();
        boolean isS = true;
        for (char c : sChars) {
            set.add(c);
            if (set.size() >= 26)
                break;
        }
        for (int i = 0; i < sChars.length-1; i++) {
            if (!(sChars[i+1] >= sChars[i]))
                isS = false;
        }
        for (char c : mChars) {
            if (!set.contains(c)){
                System.out.println(-1);
                return;
            }
        }
        int mIndex = 0;
        int sIndex = 0;
        int voidChar = 0;
        while (mIndex < mChars.length){
            if (sChars[sIndex] == mChars[mIndex]){
                mIndex++;
                sIndex++;
                if (isS){
                    if (mIndex > 0 && mIndex < mChars.length){
                        if (mChars[mIndex] < mChars[mIndex-1]){
                            voidChar += sChars.length-sIndex-1;
                            sIndex = 0;
                        }
                    }
                }
            } else {
                sIndex++;
                voidChar++;
            }
            if (sIndex >= sChars.length)
                sIndex %= sChars.length;
        }
        System.out.println(voidChar);
    }
}
