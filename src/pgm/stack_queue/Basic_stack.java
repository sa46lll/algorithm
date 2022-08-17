package pgm.stack_queue;

import java.util.Stack;

public class Basic_stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // 데이터 생성
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        // 꺼내지 않고 값을 조회
        System.out.println(stack.peek());
        System.out.println(stack);
        stack.pop();
    }
}
