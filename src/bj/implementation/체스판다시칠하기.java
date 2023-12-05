package bj.implementation;

import java.io.*;
import java.util.*;

public class 체스판다시칠하기 {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        map = new int[height][width];

        for (int i = 0; i < height; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < width; j++) {
                map[i][j] = line[j].equals("B") ? 1 : 0;
            }
        }

        int min = width * height;
        for (int i = 0; i <= map.length - 8; i++) {
            for (int j = 0; j <= map[0].length - 8; j++) {
                min = Math.min(min, getCount(i, j));
            }
        }
        System.out.println(min);
    }

    static int getCount(int startX, int startY) {
        int count = 0;
        for (int i = startX; i < startX + 8; i++) {
            for (int j = startY; j < startY + 8; j++) {
                int value = (i + j) % 2;
                if (map[i][j] != value) {
                    count++;
                }
            }
        }
        return Math.min(count, 64 - count);
    }
}
