package pgm.stack_queue;

import java.util.Stack;

public class 올바른괄호 {
    static boolean solution(String s) {
        /* // Stack
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
        /*/

        int stack = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') stack++;
            else {
                if (stack == 0) return false;
                stack--;
            }
        }
        return stack == 0;
        //*/
    }

    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
    }
}
