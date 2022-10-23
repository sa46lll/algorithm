package leetcode.string;

public class ReverseString2 {
    static String reverseStr(String s, int k) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.length(); i += k * 2) {
            result.append(reverseWord(s.substring(i, i + k)));
            result.append(s.substring(i + k, i + 2 * k));
            System.out.println("i = " + i);
        }
        return result.toString();
    }

    private static String reverseWord(String word) {
        String result = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            result = result + word.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 3)); //bacdfeg
    }
}
