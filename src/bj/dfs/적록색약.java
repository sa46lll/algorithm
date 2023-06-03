package bj.dfs;

import java.io.*;

public class 적록색약 {

    static int n;
    static char[][] map;
    static char[][] map2;
    static boolean[][] visited;
    static boolean[][] visited2;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        map2 = new char[n][n];
        visited = new boolean[n][n];
        visited2 = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
            String line2 = line.replace("R", "G");
            map2[i] = line2.toCharArray();
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    result++;
                    dfs(i, j, visited, map);
                }
            }
        }
        int result2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited2[i][j]) {
                    result2++;
                    dfs(i, j, visited2, map2);
                }
            }
        }
        System.out.println(result);
        System.out.println(result2);
    }

    private static void dfs(int x, int y, boolean[][] visited, char[][] map) {
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (checkValidation(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == map[x][y]) {
                dfs(nextX, nextY, visited, map);
            }
        }
    }

    private static boolean checkValidation(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
