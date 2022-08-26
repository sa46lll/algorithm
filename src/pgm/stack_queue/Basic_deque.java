package pgm.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

public class Basic_deque {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.offerFirst(1);
        System.out.println(deque);

        deque.offerLast(2);
        System.out.println(deque);

        deque.offerFirst(3);
        System.out.println(deque);

        deque.offerLast(4);
        System.out.println(deque);

        deque.pollFirst();
        System.out.println(deque);
        deque.pollLast();
        System.out.println(deque);
    }
}
