package bj.implementation;

import java.io.*;
import java.util.*;

public class 정수삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++) {
                arr[i - 1][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    arr[i][j] += arr[i - 1][j];
                } else if (j == i) {
                    arr[i][j] += arr[i - 1][j - 1];
                } else {
                    arr[i][j] = arr[i][j] + Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
                }
            }
        }

        int max = 0;
        for (int i : arr[arr.length - 1]) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}
