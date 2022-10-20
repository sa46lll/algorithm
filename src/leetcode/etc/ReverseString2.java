package leetcode.etc;

public class ReverseString2 {
    static public void reverse(char[] s) {
        if (s == null || s.length < 2) return;
        reverseStringRecur(s, 0, s.length-1);
    }

    private static void reverseStringRecur(char[] s, int i, int j) {
        if (i >= j) return;
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        reverseStringRecur(s, i+1, j-1);
    }

    public static void main(String[] args) {
        reverse("hello".toCharArray());
    }
}
