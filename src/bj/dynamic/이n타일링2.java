package bj.dynamic;

import java.util.*;

public class 이n타일링2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
