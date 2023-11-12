package bj.implementation;

import java.util.*;

public class 피보나치수2 {

    private int n;
    private long[] sequence;

    public static void main(String[] args) {
        new 피보나치수2().solution();
    }

    private void solution() {
        initializeFromUserInput();
        System.out.println(fibonacci(n));
    }

    private void initializeFromUserInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sequence = new long[n + 1];
        sequence[0] = 0;
        sequence[1] = 1;
    }

    private long fibonacci(int n) {
        for (int i = 2; i <= n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence[n];
    }
}
