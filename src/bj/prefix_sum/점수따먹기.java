package bj.prefix_sum;

import java.io.*;
import java.util.*;

public class 점수따먹기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];

        for (int i = 1; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 누적합
        int[][] prefix = new int[n + 1][m + 1];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                prefix[i][j] = map[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < prefix.length; i++) {
            for (int j = 1; j < prefix[0].length; j++) {
                for (int k = i; k < prefix.length; k++) {
                    for (int l = j; l < prefix[0].length; l++) {
                        max = Math.max(max, prefix[k][l] - prefix[i - 1][l] - prefix[k][j - 1] + prefix[i - 1][j - 1]);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
