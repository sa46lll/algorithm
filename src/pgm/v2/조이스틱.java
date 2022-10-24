package pgm.v2;

public class 조이스틱 {

    static int solution(String name) {
        int answer = 0;
        int move = name.length();
        for (int i = 0; i < name.length(); i++) {
            int c = name.charAt(i);
            if (c < 'N') {
                answer += (c - 'A');
                continue;
            } else {
                answer += ('Z' - c + 1);
            }

            int aIndex = i + 1;
            while (aIndex < name.length() && name.charAt(aIndex) == 'A') {
                aIndex++;
            }
            move = Math.min(move, i * 2 + name.length() - aIndex);
            move = Math.min(move, (name.length() - aIndex) * 2 + i);
        }
        return answer + move;
    }

    public static void main(String[] args) {
        System.out.println(solution("JEROEN")); // 56
    }
}
