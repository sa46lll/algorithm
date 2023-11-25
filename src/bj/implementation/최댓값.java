package bj.implementation;

import java.io.*;
import java.util.*;

public class 최댓값 {

    public static void main(String[] args) throws IOException {
        new 최댓값().solution();
    }

    private void solution() throws IOException {
        int[][] map = new int[10][10];
        int max = 0;
        int[] result = new int[] {1, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < map.length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > max) {
                    max = map[i][j];
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        System.out.println(max);
        System.out.println(result[0] + " " + result[1]);
    }
}
