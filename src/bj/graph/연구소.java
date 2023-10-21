package bj.graph;

import java.io.*;
import java.util.*;

public class 연구소 {

    private int[][] map;
    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};
    private int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        new 연구소().solution();
    }

    private void solution() throws IOException {
        getUserInput();
        buildWallsDfs(0);
        System.out.println(result);
    }

    private void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        map = new int[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private void buildWallsDfs(int wallCount) {
        if (wallCount == 3) {
            calculateSafeArea(map);
            return;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWallsDfs(wallCount + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private void calculateSafeArea(int[][] map) {
        int[][] infectedMap = performInfectionBFS(map);
        getSafeArea(infectedMap);
    }

    private int[][] performInfectionBFS(int[][] map) {
        int[][] infectedMap = new int[map.length][map[0].length];
        Queue<Node> queue = new LinkedList<>();

        // 바이러스 시작 지점들 queue에 삽입
        for (int i = 0; i < infectedMap.length; i++) {
            for (int j = 0; j < infectedMap[0].length; j++) {
                infectedMap[i][j] = map[i][j];
                if (infectedMap[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }
        // 바이러스 감염
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];
                if (checkValidation(map, nextX, nextY) && infectedMap[nextX][nextY] == 0) {
                    infectedMap[nextX][nextY] = 2;
                    queue.add(new Node(nextX, nextY));
                }
            }
        }
        return infectedMap;
    }

    private boolean checkValidation(int[][] map, int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length;
    }

    private void getSafeArea(int[][] map) {
        int safeArea = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        result = Math.max(result, safeArea);
    }

    static class Node {

        private int x;
        private int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
