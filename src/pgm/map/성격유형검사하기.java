package pgm.map;

import java.util.*;

public class 성격유형검사하기 {

    private final char[] chars = new char[]{'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
    private Map<Character, Integer> charMap = new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        for (int i = 0; i < survey.length; i++) {
            executeSurvey(survey[i], choices[i]);
        }
        return getResult();
    }

    private void executeSurvey(String s, int choice) {
        char[] characters = s.toCharArray();
        if (choice > 4) {
            charMap.put(characters[1], charMap.getOrDefault(characters[1], 0) + choice - 4);
            return;
        }
        charMap.put(characters[0], charMap.getOrDefault(characters[0], 0) + 4 - choice);
    }

    private String getResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i += 2) {
            int score1 = charMap.getOrDefault(chars[i], 0);
            int score2 = charMap.getOrDefault(chars[i + 1], 0);
            if (score1 >= score2) {
                sb.append(chars[i]);
                continue;
            }
            sb.append(chars[i + 1]);
        }
        return sb.toString();
    }
}
