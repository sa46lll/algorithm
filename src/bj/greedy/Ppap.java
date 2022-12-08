package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ppap {
    static final String PPAP = "PPAP";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P') {
                stack.push('P');
                continue;
            }
            if (stack.size() >= 2 && i != s.length() - 1 && s.charAt(i + 1) == 'P') {
                stack.pop();
                stack.pop();
                continue;
            }
            System.out.println("NP");
            return;
        }
        if (stack.size() == 1) {
            System.out.println(PPAP);
            return;
        }
        System.out.println("NP");
    }
}
