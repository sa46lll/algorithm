package pgm.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            float p = 100 - progresses[i];
            float s = speeds[i];
            queue.add((int)Math.ceil(p / s));
        }

        Queue<Integer> answer = new LinkedList<>();

        int d = queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (d >= n) {
                count++;
                continue;
            }
            answer.add(count);
            count = 1;
            d = n;
        }
        answer.offer(count);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        System.out.println(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }
}
