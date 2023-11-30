package bj.implementation;

import java.io.*;
import java.util.*;

public class 제로 {

    public static void main(String[] args) throws IOException {
        new 제로().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if (m == 0) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
                continue;
            }
            deque.add(m);
        }
        printResult(deque);
    }

    private void printResult(Deque<Integer> deque) {
        int sum = 0;
        while (!deque.isEmpty()) {
            sum += deque.poll();
        }
        System.out.println(sum);
    }
}
