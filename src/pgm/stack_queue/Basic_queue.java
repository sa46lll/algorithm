package pgm.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Basic_queue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // 데이터 생성
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue);

        // 값을 꺼내고 전체 조회
        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);

        // 꺼내지 않고 값을 조회
        System.out.println(queue.peek());
    }
}
