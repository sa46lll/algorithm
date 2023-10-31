package bj.dynamic;

import java.io.*;
import java.util.*;

public class RGB거리 {

    private int houseCount;
    private int[][] cost;
    private int[][] dp;

    public static void main(String[] args) throws IOException {
        new RGB거리().solution();
    }

    private void solution() throws IOException {
        initializeFromUserInput();
        paint();
        printResult();
    }

    private void initializeFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        houseCount = Integer.parseInt(br.readLine());
        cost = new int[houseCount + 1][3];
        dp = new int[houseCount + 1][3];

        for (int i = 1; i < cost.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
    }

    private void paint() {
        for (int i = 1; i < cost.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }
    }

    private void printResult() {
        System.out.println(Math.min(dp[houseCount][0], Math.min(dp[houseCount][1], dp[houseCount][2])));
    }
}
