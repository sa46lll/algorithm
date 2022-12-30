package bj.bfs;

import java.io.*;
import java.util.*;

public class 나이트의이동 {

    static int side;
    static int[][] map;
    static boolean[][] visited;
    static Node2 start;
    static Node2 end;
    static int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
    static int[] dy = {-2, 2, -2, 2, -1, 1, 1, -1,};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            side = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = new Node2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            end = new Node2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            map = new int[side][side];
            visited = new boolean[side][side];

            bfs();
            System.out.println(map[end.x][end.y]);
        }
    }

    private static void bfs() {
        Queue<Node2> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Node2 node = queue.poll();
            if (node.x == end.x && node.y == end.y) {
                return;
            }
            for (int i = 0; i < dx.length; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if (checkValidation(nextX, nextY) && !visited[nextX][nextY]) {
                    queue.offer(new Node2(nextX, nextY));
                    map[nextX][nextY] = map[node.x][node.y] + 1;
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    private static boolean checkValidation(int x, int y) {
        return x >= 0 && x < side && y >= 0 && y < side;
    }
}

class Node2 {
    int x;
    int y;

    Node2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
