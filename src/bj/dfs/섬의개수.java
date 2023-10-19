package bj.dfs;

import java.io.*;
import java.util.*;

public class 섬의개수 {

    private static int width;
    private static int height;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0, 1, -1, -1, 1};
    private static final StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            getUserInput(br);
            if (width == 0 && height == 0) {
                break;
            }
            appendIslandCountResult(calculateIslandCount(map));
        }
        System.out.println(result);
    }

    private static void getUserInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        map = new int[height][width];
        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int calculateIslandCount(int[][] map) {
        int islandCount = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandCount++;
                    dfs(map, i, j);
                }
            }
        }
        return islandCount;
    }

    private static void dfs(int[][] map, int startX, int startY) {
        visited[startX][startY] = true;
        for (int i = 0; i < dx.length; i++) {
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];
            if (checkValidation(map, nextX, nextY) && map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                dfs(map, nextX, nextY);
            }
        }
    }

    private static void appendIslandCountResult(int islandCount) {
        result.append(islandCount).append("\n");
    }

    private static boolean checkValidation(int[][] map, int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length;
    }
}
