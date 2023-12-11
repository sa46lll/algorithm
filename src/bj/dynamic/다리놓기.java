package bj.dynamic;

import java.io.*;
import java.util.*;

public class 다리놓기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        double[] dp = new double[31];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] * i;
        }

        while (testCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == m) {
                sb.append(1).append("\n");
                continue;
            }
            sb.append((int) (dp[m] / dp[n] / dp[m - n])).append("\n");
        }

        System.out.println(sb);
    }
}
