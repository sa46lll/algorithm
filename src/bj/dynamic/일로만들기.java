package bj.dynamic;

import java.util.*;

public class 일로만들기 {

    private int n;
    private int[] dp;

    public static void main(String[] args) {
        new 일로만들기().solution();
    }

    private void solution() {
        getUserInput();
        calculate();
        System.out.println(dp[n]);
    }

    private void calculate() {
        for (int i = 2 ; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dp = new int[n + 1];
    }
}
