package bj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 그림 {
    static int width;
    static int height;
    static int[][] draw;
    static boolean[][] visited;
    static int[] x = {0, 0, -1, 1};
    static int[] y = {-1, 1, 0, 0};
    static int area;
    static int count;
    static int maxArea;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        height = Integer.parseInt(s[0]);
        width = Integer.parseInt(s[1]);
        draw = new int[height][width];
        visited = new boolean[height][width];
        for (int h = 0; h < height; h++) {
            String[] s1 = br.readLine().split(" ");
            for (int w = 0; w < width; w++) {
                draw[h][w] = Integer.parseInt(s1[w]);
            }
        }
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (!visited[x][y] && draw[x][y] == 1) {
                    area = 1;
                    dfs(x, y);
                    count++;
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
    }

    private static void dfs(int moveX, int moveY) {
        visited[moveX][moveY] = true;
        for (int i = 0; i < x.length; i++) {
            int i1 = moveX + x[i];
            int i2 = moveY + y[i];
            if (checkRange(i1, i2) && !visited[i1][i2] && draw[i1][i2] == 1) {
                area++;
                visited[i1][i2] = true;
                dfs(i1, i2);
            }
        }
    }

    private static boolean checkRange(int x, int y) {
        return (x >= 0 && x < height && y >= 0 && y < width);
    }
}
