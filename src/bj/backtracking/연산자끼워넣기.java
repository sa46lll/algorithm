package bj.backtracking;

import java.io.*;
import java.util.*;

public class 연산자끼워넣기 {

    private int[] naturals;
    private int[] operator = new int[4]; // 각 연산자의 개수 (+, -, *, /)
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        new 연산자끼워넣기().solution();
    }

    private void solution() throws IOException {
        initializeFromUserInput();
        dfs(naturals[0], 1);
        printResult();
    }

    private void printResult() {
        System.out.println(max);
        System.out.println(min);
    }

    private void dfs(int value, int depth) {
        if (depth == naturals.length) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        for (int i = 0; i < operator.length; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) { // java 11 가정
                    case 0: {
                        dfs(value + naturals[depth], depth + 1);
                        break;
                    }
                    case 1: {
                        dfs(value - naturals[depth], depth + 1);
                        break;
                    }
                    case 2: {
                        dfs(value * naturals[depth], depth + 1);
                        break;
                    }
                    case 3: {
                        dfs(value / naturals[depth], depth + 1);
                        break;
                    }
                    default: throw new IllegalArgumentException();
                }
                operator[i]++;
            }
        }
    }

    private void initializeFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        naturals = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < naturals.length; i++) {
            naturals[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operator.length; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
    }
}
