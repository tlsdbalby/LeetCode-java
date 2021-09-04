package lby.com.meituan;

import java.util.HashMap;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        short[][] days = new short[k][3];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 3; j++) {
                days[i][j] = sc.nextShort();
            }
        }
        long des = 0;
        short[][] land = new short[n][m];
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            short x = days[i][0];
            x--;
            short y = days[i][1];
            y--;
            short r = days[i][2];
            for (int p1 = x-r+1; p1<=x+r-1; p1++){
                for (int p2 = y-r+1; p2<=y+r-1; p2++){
                    String key =""+p1+"-"+p2;
                    if (hashMap.containsKey(key))
                        des += (i+1 - hashMap.get(key));
                    else des += (i+1);
                    hashMap.put(key, i+1);
                }
            }
            String[] temp = {""+x+"-"+(y-r), ""+x+"-"+(y+r), ""+(x-r)+"-"+y, ""+(x+r)+"-"+y};
            for (String key : temp) {
                if (hashMap.containsKey(key))
                    des += (i+1 - hashMap.get(key));
                else des += (i+1);
                hashMap.put(key, i+1);
            }
        }
//        for (int i = 0; i < k; i++) {
//            for (short ii = 0; ii < land.length; ii++) {
//                for (short j = 0; j < land[ii].length; j++) {
//                    land[ii][j] += 1;
//                }
//            }
//            short x = days[i][0];
//            x--;
//            short y = days[i][1];
//            y--;
//            short r = days[i][2];
//            for (int p1 = x-r+1; p1<=x+r-1; p1++){
//                for (int p2 = y-r+1; p2<=y+r-1; p2++){
//                    des += land[p1][p2];
//                    land[p1][p2] = 0;
//                }
//            }
//            des += land[x][y-r];
//            land[x][y-r] = 0;
//            des += land[x][y+r];
//            land[x][y+r] = 0;
//            des += land[x-r][y];
//            land[x-r][y] = 0;
//            des += land[x+r][y];
//            land[x+r][y] = 0;
//        }
        long re = m*n*k - des;
        System.out.println(re);
    }
    private static void updateArr(short[][] arr){

    }
}
