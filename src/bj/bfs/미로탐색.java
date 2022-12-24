package bj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색 {

    static int n, m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        maze = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(s1[j]);
            }
        }
        bfs();
        System.out.println(maze[n - 1][m - 1]);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];
                if (checkRange(nextX, nextY) && !visited[nextX][nextY] && maze[nextX][nextY] == 1) {
                    queue.offer(new Node(nextX, nextY));
                    maze[nextX][nextY] = maze[node.x][node.y] + 1;
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    static boolean checkRange(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return true;
        }
        return false;
    }
}

class Node {

    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
