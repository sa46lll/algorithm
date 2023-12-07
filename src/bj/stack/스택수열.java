package bj.stack;

import java.io.*;
import java.util.*;

public class 스택수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int start = 1;
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if (m >= start) { // 큐에 넣어야 함.
                while (true) {
                    sb.append("+\n");
                    deque.add(start++);
                    if (start > m) {
                        sb.append("-\n");
                        deque.pollLast();
                        break;
                    }
                }
                continue;
            }// 큐에 있을 수도 있음
            if (deque.isEmpty()) {
                System.out.println("NO");
                return;
            }
            while (true) {
                sb.append("-\n");
                if (deque.pollLast() == m) {
                    break;
                }
                if (deque.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb);
    }
}
