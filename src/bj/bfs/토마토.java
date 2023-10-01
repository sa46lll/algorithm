package bj.bfs;

import java.io.*;
import java.util.*;

public class 토마토 {

    static int row; // 상자의 가로 칸의 수
    static int col; // 상자의 세로 칸의 수
    static int boxCount; // 상자의 개수
    static int[][][] map;
    static int[][][] visited;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        promptFromUserInput();
        bfs();
        printResult();
    }

    private static void promptFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        boxCount = Integer.parseInt(st.nextToken());

        map = new int[boxCount][col][row];
        visited = new int[boxCount][col][row];
        for (int i = 0; i < boxCount; i++) {
            for (int j = 0; j < col; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < row; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == -1) {
                        visited[i][j][k] = -1;
                    }
                    if (map[i][j][k] == 1) {
                        visited[i][j][k] = 1;
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int z = poll[2];

            for (int i = 0; i < dx.length; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextZ = z + dz[i];

                if (checkValidation(nextX, nextY, nextZ) && map[nextX][nextY][nextZ] == 0 && visited[nextX][nextY][nextZ] == 0) {
                    visited[nextX][nextY][nextZ] = visited[x][y][z] + 1;
                    queue.add(new int[]{nextX, nextY, nextZ});
                }
            }
        }
    }

    private static boolean checkValidation(int x, int y, int z) {
        return x >= 0 && x < boxCount && y >= 0 && y < col && z >= 0 && z < row;
    }

    private static void printResult() {
        int result = 0;
        for (int i = 0; i < boxCount; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < row; k++) {
                    result = Math.max(result, visited[i][j][k]);
                    if (visited[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(result - 1);
    }
}
