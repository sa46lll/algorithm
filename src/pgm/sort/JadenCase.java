package pgm.sort;

public class JadenCase {
    static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String answer = s.toLowerCase();
        char last = ' ';
        for (char c : answer.toCharArray()) {
            if (last == ' ') {
                c = Character.toUpperCase(c);
            }
            sb.append(c);
            last = c;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
    }
}
