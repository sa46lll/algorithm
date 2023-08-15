package bj.string;

import java.util.*;

public class 비밀번호발음하기 {

    static final String VOWELS = "aeiou";
    static final String PASSWORD_VALIDATE_OUTPUT = "<%s> is acceptable.";
    static final String PASSWORD_INVALIDATE_OUTPUT = "<%s> is not acceptable.";
    static List<String> passwords;

    public static void main(String[] args) {
        promptFromUserInput();

        StringBuilder sb = new StringBuilder();
        for (String password : passwords) {
            if (validatePassword(password)) {
                sb.append(String.format(PASSWORD_VALIDATE_OUTPUT, password)).append("\n");
                continue;
            }
            sb.append(String.format(PASSWORD_INVALIDATE_OUTPUT, password)).append("\n");
        }
        System.out.println(sb);
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
            if (lastChar == c && !isExceptionCase(c)) {
                return false;
            }
            lastChar = c;
        }
        if (!hasVowel) {
            return false;
        }
        return true;
    }

    private static boolean isExceptionCase(char c) {
        return c != 'e' && c != 'o';
    }
}
