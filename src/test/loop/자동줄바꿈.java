package test.loop;

import java.util.ArrayList;
import java.util.List;

class 자동줄바꿈 {

    static final int KOREAN_SIZE = 2;
    static final int ENGLISH_INTEGER_SIZE = 1;

    public static List<String> solution(String text, int n) {
        StringBuilder sb = new StringBuilder();
        char[] chars = text.toCharArray();

        List<String> result = new ArrayList<>();
        int size = 0;
        for (char c : chars) {
            if (isKorean(c) && size + KOREAN_SIZE <= n) {
                sb.append(c);
                size += KOREAN_SIZE;
                continue;
            }
            if (!isKorean(c) && size + ENGLISH_INTEGER_SIZE <= n) {
                sb.append(c);
                size += ENGLISH_INTEGER_SIZE;
                continue;
            }
            result.add(sb.toString());
            sb = new StringBuilder().append(c);
            size = isKorean(c) ? KOREAN_SIZE : ENGLISH_INTEGER_SIZE; // 한글이면 2, 영어/숫자면 1부터 다시 시작
        }

        // 마지막에 남은 문자열이 있으면 추가
        if (!sb.isEmpty()) {
            result.add(sb.toString());
        }
        return result;
    }

    private static boolean isKorean(char c) {
        if (c >= '가' && c <= '힣') {
            return true;
        }
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return false;
        }
        throw new IllegalArgumentException("Invalid character: " + c);
    }

    public static void main(String[] args) {
        solution(
            "가나다abc123가나다abc123가나다abc123가나다abc123가나다abc123가나다abc123가나다abc123가나다abc123",
            20);

        solution(
            "가나다abc123가나다abc123가나다abc123가나다abc123가나다abc123가나다abc123가나다abc123가나다abc123",
            15);
    }
}
