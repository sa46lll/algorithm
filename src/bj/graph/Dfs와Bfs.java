package bj.graph;

import java.io.*;
import java.util.*;

public class Dfs와Bfs {

    static int vertexCount;
    static int startVertex;
    static int[][] map;
    static boolean[] visitedByDfs;
    static boolean[] visitedByBfs;
    static final StringBuilder dfsResult = new StringBuilder();

    public static void main(String[] args) throws IOException {
        getUserInput();
        calculateDfsResult(map, visitedByDfs, startVertex);
        String bfsResult = calculateBfsResult(map, visitedByBfs, startVertex);
        displayResult(dfsResult, bfsResult);
    }

    private static void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertexCount = Integer.parseInt(st.nextToken()); // 정점의 개수
        int edgeCount = Integer.parseInt(st.nextToken()); // 간선의 개수
        startVertex = Integer.parseInt(st.nextToken()); // 시작하는 정점
        map = new int[vertexCount + 1][vertexCount + 1];
        visitedByDfs = new boolean[vertexCount + 1];
        visitedByBfs = new boolean[vertexCount + 1];

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            map[num1][num2] = 1;
            map[num2][num1] = 1;
        }
    }

    private static void calculateDfsResult(int[][] map, boolean[] visited, int startVertex) {
        visited[startVertex] = true;
        dfsResult.append(startVertex).append(" ");
        for (int i = 1; i <= vertexCount; i++) {
            if (map[startVertex][i] == 1 && !visited[i]) {
                calculateDfsResult(map, visited, i);
            }
        }
    }

    private static String calculateBfsResult(int[][] map, boolean[] visited, int startVertex) {
        StringBuilder bfsResult = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;
        bfsResult.append(startVertex).append(" ");

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 1; i <= vertexCount; i++) {
                if (map[poll][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    bfsResult.append(i).append(" ");
                }
            }
        }
        return bfsResult.toString();
    }

    private static void displayResult(StringBuilder dfsResult, String bfsResult) {
        StringBuilder result = dfsResult.append("\n").append(bfsResult);
        System.out.println(result);
    }
}
