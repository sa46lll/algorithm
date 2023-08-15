package bj.string;

import java.util.*;

public class 비밀번호발음하기 {

    static final String VOWELS = "aeiou";
    static final String OUTPUT_VALIDATE = "<%s> is acceptable.";
    static final String OUTPUT_INVALIDATE = "<%s> is not acceptable.";
    static List<String> passwords;

    public static void main(String[] args) {
        promptFromUserInput();

        StringBuilder sb = new StringBuilder();
        for (String password : passwords) {
            if (validatePassword(password)) {
                sb.append(String.format(OUTPUT_VALIDATE, password)).append("\n");
                continue;
            }
            sb.append(String.format(OUTPUT_INVALIDATE, password)).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean validatePassword(String password) {
        boolean hasVowel = false;
        int consecutiveVowels = 0; // 연속되는 모음 개수
        int consecutiveConsonants = 0; // 연속되는 자음 개수
        char lastChar = ' ';
        for (char c : password.toCharArray()) {
            if (VOWELS.contains(String.valueOf(c))) {
                consecutiveVowels++;
                consecutiveConsonants = 0;
                hasVowel = true;
            } else {
                consecutiveConsonants++;
                consecutiveVowels = 0;
            }
            if (consecutiveVowels >= 3 || consecutiveConsonants >= 3) {
                return false;
            }
            if (lastChar == c && c != 'e' && c != 'o') {
                return false;
            }
            lastChar = c;
        }
        if (!hasVowel) {
            return false;
        }
        return true;
    }

    private static void promptFromUserInput() {
        Scanner sc = new Scanner(System.in);
        passwords = new ArrayList<>();
        while (true) {
            String input = sc.next();
            if (input.equals("end")) {
                break;
            }
            passwords.add(input);
        }
    }
}
