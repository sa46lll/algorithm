package bj.implementation;

import java.io.*;
import java.util.*;

public class 최소공배수 {

    private static int n;
    private static int[][] nums;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        getUserInput();
        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i][0];
            int n2 = nums[i][1];

            if (n1 == 1 || n2 == 1) {
                result[i] = Math.max(n1, n2);
                continue;
            }
            result[i] = getLcm(n1, n2);
        }
        printResult();
    }

    private static void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n][2];
        result = new int[n];
        for (int i = 0; i < nums.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    private static int getLcm(int n1, int n2) {
        return n1 * n2 / getGcd(n1, n2);
    }

    private static int getGcd(int n1, int n2) {
        if (n1 % n2 == 0) {
            return n2;
        }
        return getGcd(n2, n1 % n2);
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            sb.append(r).append("\n");
        }
        System.out.println(sb);
    }
}
