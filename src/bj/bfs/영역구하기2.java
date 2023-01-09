package bj.bfs;

import java.io.*;
import java.util.*;

public class 영역구하기2 {

    static int m;
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for (int i = startX; i < endX; i++) {
                for (int j = startY; j < endY; j++) {
                    map[i][j] = 1;
                }
            }
        }

        int count = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    count++;
                    area = 0;
                    bfs(i, j);
                    result.add(area);
                }
            }
        }
        Collections.sort(result);
        System.out.println(count);
        result.forEach(i -> System.out.print(i + " "));
    }

    private static void bfs(int x, int y) {
        Queue<Node3> queue = new LinkedList<>();
        queue.add(new Node3(x, y));
        visited[x][y] = true;
        area++;
        while (!queue.isEmpty()) {
            Node3 node = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];
                if (checkValidation(nextX, nextY) && map[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                    queue.offer(new Node3(nextX, nextY));
                    visited[nextX][nextY] = true;
                    area++;
                }
            }
        }
    }

    private static  boolean checkValidation(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}

class Node3 {
    int x;
    int y;

    Node3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
