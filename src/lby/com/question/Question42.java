package lby.com.question;
/*
* 未完成！
* */
public class Question42 {
    public static void main(String[] args) {
        System.out.println(isMatch("adceb", "a*b"));
    }
    public static boolean isMatch(String s, String p) {
        int s_l = s.length();
        int p_l = p.length();
        if (s_l < p_l)
            return false;
        int i = 0;
        int j = 0;
        while (i < s_l && j < p_l){
            if (i == s_l-1 && j == p_l-1)
                return true;
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
                i++;
                j++;
                continue;
            }
            if (p.charAt(j) == '*'){
                int ti = s_l - 1;
                int tp = p_l - 1;
                for (int k = tp; k > j; k--) {
                    if (s.charAt(ti) == p.charAt(k) || p.charAt(k) == '?'){
                        ti--;
                    } else if (p.charAt(k) == '*'){

                    } else return false;
                }
                return true;
            }
        }
        return false;
    }
}
