package lby.com.test;

public class Test {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        str.append(8);
        str.append(str.charAt(str.length()-1)+1);
        System.out.println(str);
    }
}
