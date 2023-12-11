package bj.dynamic;

import java.io.*;
import java.util.*;

public class 가장긴증가하는부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sequence = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = 1; i < sequence.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (sequence[j] < sequence[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        int result = 0;
        for (int i : dp) {
            result = Math.max(result, i);
        }
        System.out.println(result);
    }
}
