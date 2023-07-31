package bj.priorityqueue;

import java.util.*;

public class 최소힙 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            if (num == 0) {
                int minValue = pq.isEmpty() ? 0 : pq.poll();
                sb.append(minValue).append("\n");
                continue;
            }
            pq.add(num);
        }
        System.out.println(sb);
    }
}
