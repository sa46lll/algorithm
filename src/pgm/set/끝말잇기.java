package pgm.set;

import java.util.HashSet;
import java.util.Set;

public class 끝말잇기 {
    static boolean solution(String[] words) {
        Set<String> set = new HashSet<>();

        set.add(words[0]);
        char last = words[0].charAt(words[0].length() - 1); // 마지막 글자

        for (int i=1; i<words.length; i++) {
            String w = words[i];
            if (w.charAt(0) != last) return false;
            if (!set.add(w)) return false; // 중복값 체크
            last = w.charAt(w.length() - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"tank", "kick", "know", "wheel", "land", "dream"}));
        System.out.println(solution(new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
    }
}
