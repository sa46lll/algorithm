package bj.priorityqueue;

import java.util.*;

/**
 * maxPq, minPq 를 번갈아 넣어주며 크기를 맞춰줌
 * maxPq의 max값이 minPq의 min 값보다 크면 넘겨주면서 모든 minPq의 값이 maxPq보다 커지도록 옮겨줌
 * maxPq는 전체에서 작은 값들만 들어가진 상태이므로, 그 중 가장 큰 값을 peek 하여 출력
 */
public class 가운데를말해요 {

    static PriorityQueue<Integer> minPq = new PriorityQueue<>();
    static PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());

    static int solution(int num) {
        if (minPq.size() == maxPq.size()) {
            maxPq.offer(num);
        } else {
            minPq.offer(num);
        }

        if (!minPq.isEmpty() && !maxPq.isEmpty() && minPq.peek() < maxPq.peek()) {
            int tmp = minPq.poll();
            minPq.offer(maxPq.poll());
            maxPq.offer(tmp);
        }

        if (maxPq.isEmpty()) {
            throw new IllegalStateException();
        }
        return maxPq.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int middleNum = solution(scanner.nextInt());
            sb.append(middleNum).append("\n");
        }
        System.out.println(sb);
    }
}
