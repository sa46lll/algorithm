package bj.implementation;

import java.io.*;
import java.util.*;

public class 덩치 {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] rating = new int[n];
        for (int i = 0; i < map.length; i++) {
            int biggerThanMe = 1;
            for (int j = 0; j < map.length; j++) {
                if (i == j) {
                    continue;
                }
                if (map[i][0] < map[j][0] && map[i][1] < map[j][1]) {
                    biggerThanMe++;
                }
            }
            rating[i] = biggerThanMe;
        }

        StringBuilder sb = new StringBuilder();
        for (int r : rating) {
            sb.append(r).append(" ");
        }
        System.out.println(sb);
    }
}
