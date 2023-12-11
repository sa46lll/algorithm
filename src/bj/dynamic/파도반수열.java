package bj.dynamic;

import java.io.*;

public class 파도반수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (testCount-- >0) {
            int n = Integer.parseInt(br.readLine());

            long[] dp = new long[101];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;

            for (int i = 4; i < n + 1; i++) {
                dp[i] = dp[i - 2] + dp[i - 3];
            }
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
