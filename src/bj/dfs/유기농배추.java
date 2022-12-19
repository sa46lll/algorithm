package bj.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 유기농배추 {
    static int m, n, k;
    static int[][] farm;
    static boolean[][] visited;
    static int[] x = {0, 0, -1, 1}, y = {-1, 1, 0, 0};
    static int[] output;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(bf.readLine());
        output = new int[testNum];
        for (int i = 0; i < testNum; i++) {
            String[] s = bf.readLine().split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            k = Integer.parseInt(s[2]);
            farm = new int[m][n];
            visited = new boolean[m][n];
            for (int j = 0; j < k; j++) {
                String[] xy = bf.readLine().split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                farm[x][y] = 1;
            }
            int result = 0;
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (farm[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        result++;
                    }
                }
            }
            output[i] = result;
        }
        Arrays.stream(output).forEach(System.out::println);
    }

    private static void dfs(int moveX, int moveY) {
        visited[moveX][moveY] = true;
        for (int i = 0; i < x.length; i++) {
            int i1 = moveX + x[i];
            int i2 = moveY + y[i];
            // 양배추가 있고 방문하지 않은 곳
            if (checkRange(i1, i2) && farm[i1][i2] == 1 && !visited[i1][i2]) {
                visited[i1][i2] = true;
                dfs(i1, i2);
            }
        }
    }

    private static boolean checkRange(int x, int y) {
        return (x >= 0 && x < m && y >=0 && y < n);
    }
}
