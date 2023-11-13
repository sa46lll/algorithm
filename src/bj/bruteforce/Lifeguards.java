package bj.bruteforce;

import java.io.*;
import java.util.*;

public class Lifeguards {

    private int n;
    private int[][] arr;
    private int lastTime = 0;
    private int max = 0;

    public static void main(String[] args) throws IOException {
        new Lifeguards().solution();
    }

    private void solution() throws IOException {
        getUserInput();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j <= lastTime; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (i == k) {
                        continue;
                    }
                    if (arr[k][0] <= j && arr[k][1] > j) {
                        count++;
                        break;
                    }
                }
            }
            max = Math.max(count, max);
        }
        System.out.println(max);
    }

    private void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            lastTime = Math.max(lastTime, arr[i][1]);
        }
    }
}
