package lby.com.question;
/*
* LCP 29. 乐团站位
*   某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，
*   每个位置站有一位成员。乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。
*   为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9
*   循环重复排列。例如当 num = 5 时，站位如图所示 (转圈赋值)
* 解:e
*   思路1: 数学法, 计算每圈矩形的左上角值, 其他位置的值都可以通过这个值推算出来, 因此使用一个一个数组保存每圈矩形的左上角值
*       e[0] = 1, e[i+1] = (e[i]+4*(num-2*(i-1)-1))%9  0<=i<=num/2
* */
public class LCP29 {
    public static void main(String[] args) {
        System.out.println(orchestraLayout(4, 1, 2));
    }
    public static int orchestraLayout(int num, int xPos, int yPos) {
        int len = num / 2;
        long n = num;
        int m = Math.min(Math.min(xPos, num-1-xPos), Math.min(yPos, num-1-yPos));
        long e;
        e = 1;
        int i;
        for (i = 0; i <= m; i++) {
            if (i != 0)
                e = getRe(e + 4*(n-2*(i-1)-1));
        }
        i--;
        int edge = (num-2*i-1);
        if (xPos == i)
            return getRe((e+yPos-i));
        if (yPos == num-1-i)
            return getRe(e+edge+xPos-i);
        if (xPos == num-1-i)
            return getRe(e+2*edge+edge-yPos+i);
        if (yPos == i)
            return getRe(e+3*edge+edge-xPos+i);
        return getRe(e+8);
    }
    public static int getRe(long i){
        return (int)((i-1)%9+1);
    }
}
