package leetcode.string;

public class ReverseWordsInAString {
    static String reverse(String s) {
        String[] stringArray = s.split(" ");
        String result = "";
        for (String word : stringArray) {
            String reverseAfter = reverseWord(word);
            result += reverseAfter;
            result += " ";
        }
        return result.trim();
    }

    private static String reverseWord(String word) {
        String result = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            result = result + word.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse("Happy Birthday Java!"));
    }
}
