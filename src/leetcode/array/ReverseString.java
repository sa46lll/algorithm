package leetcode.array;

public class ReverseString {
    static void reverse(char[] s) {
        int low = 0;
        int high  = s.length - 1;
        while (low < high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
        System.out.println(s);

    }

    public static void main(String[] args) {
        reverse("hello".toCharArray());
    }
}
