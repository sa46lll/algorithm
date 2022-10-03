package pgm.sort;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
    static String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        return Arrays.stream(strings)
                .sorted(Comparator.comparing(s -> s.charAt(n)))
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        solution(new String[] {"sun", "bed", "car"}, 1);
        solution(new String[] {"abce", "abcd", "cdx"}, 2);
    }
}
