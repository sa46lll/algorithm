package bj.implementation;

import java.util.*;

public class 팰린드롬 {

    public static void main(String[] args) {
        String word = getWord();
        int result = isPelindrom(word) ? 1 : 0;
        System.out.println(result);
    }

    private static String getWord() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private static boolean isPelindrom(String word) {
        StringBuilder sb = new StringBuilder();
        char[] wordArray = word.toCharArray();
        for (int i = wordArray.length - 1; i >= 0; i--) {
            sb.append(wordArray[i]);
        }
        return word.equals(sb.toString());
    }
}
