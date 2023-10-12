package bj.bfs;

import java.io.*;
import java.util.*;

public class 벽부수고이동하기 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        promptFromUserInput();

        bfs();

        answer = answer == 0 ? -1 : answer;
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == n - 1 && node.y == m - 1) { // 종착지에 도착했을 때 종료
                answer = node.visited;
                return;
            }

            for (int i = 0; i < dx.length; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];
                int nextVisited = node.visited + 1;

                if (!checkValidation(nextX, nextY)) {
                    continue;
                }

                // 벽이 아닐 때
                if (map[nextX][nextY] != 1) {
                    // 파괴x, 방문x -> 방문 처리
                    if (!node.destroyed && !visited[nextX][nextY][0]) {
                        visited[nextX][nextY][0] = true;
                        queue.add(new Node(nextX, nextY, nextVisited, false));
                    }
                    // 파괴o, 방문x -> 방문 처리
                    else if (node.destroyed && !visited[nextX][nextY][1]) {
                        visited[nextX][nextY][1] = true;
                        queue.add(new Node(nextX, nextY, nextVisited, true));
                    }
                } else { // 벽일 때 부순다
                    if (!node.destroyed && !visited[nextX][nextY][1]) {
                        visited[nextX][nextY][1] = true;
                        queue.add(new Node(nextX, nextY, nextVisited, true));
                    }
                }
            }
        }
    }

    private static boolean checkValidation(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static void promptFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    static class Node {

        int x;
        int y;
        int visited;
        boolean destroyed;

        Node(int x, int y, int visited, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.visited = visited;
            this.destroyed = destroyed;
        }
    }
}
