package bj.implementation;

import java.util.*;

public class 요세푸스문제 {

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        int count = 1;
        while (!queue.isEmpty()) {
            if (count % k == 0) {
                sb.append(queue.poll()).append(", ");
            } else {
                int poll = queue.poll();
                queue.add(poll);
            }
            count++;
        }
        System.out.println(sb.delete(sb.length() - 2, sb.length()).append(">"));
    }
}
