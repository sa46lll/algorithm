package pgm.linear_search;

import java.util.Arrays;

public class 스킬트리 {
    static public int solution(String skill, String[] skill_trees) {
        /*
        for (String s : skill_trees) {
            String s1 = s.replaceAll("[^" + skill + "]", "");
            if (skill.startsWith(s1)) {
                answer += 1;
            }
        }
        */
        return (int) Arrays.stream(skill_trees)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(skill::startsWith)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"})); // 2
    }
}
