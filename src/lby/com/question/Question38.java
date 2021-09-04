package lby.com.question;

public class Question38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
        public static String countAndSay(int n) {
            if (n == 1)
                return "1";
            if (n == 2)
                return "11";
            String str = "11";
            for (int i = 0; i < n-2; i++) {
                char[] chars = str.toCharArray();
                int count = 1;
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < chars.length; j++) {
                    if (j < chars.length-1) {
                        if (chars[j] == chars[j + 1]) {
                            count++;
                        } else {
                            temp.append(count);
                            temp.append(chars[j]);
                            count = 1;
                        }
                    } else {
                        temp.append(count);
                        temp.append(chars[j]);
                    }
                }
                str = temp.toString();
                System.out.println(str);
            }
            return str;
        }
}
