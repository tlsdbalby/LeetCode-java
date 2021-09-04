package lby.com.question;

public class Question242 {
    public static void main(String[] args) {

    }
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        if (s.length() < t.length())
            return isAnagram(t, s);
        char[] mc = t.toCharArray();
        for (char c : mc) {
            chars[c-'a']++;
        }
        char[] rc = s.toCharArray();
        for (char c : rc) {
            if (chars[c-'a'] == 0)
                return false;
            else chars[c-'a']--;
        }
        return true;
    }
}
