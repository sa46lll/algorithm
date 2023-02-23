package bj.dfs;

import java.io.*;
import java.util.*;

public class 단지번호붙이기 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] split = s.split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    size = 1;
                    dfs(i, j);
                    list.add(size);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        list.stream().forEach(System.out::println);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (checkValidation(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
                size++;
                dfs(nextX, nextY);
            }
        }
    }

    private static boolean checkValidation(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
