package bj.floyd;

import java.io.*;
import java.util.*;

/**
 * 플로이드 연산 (floyd-warshall)
 * : 모든 정점에서 모든 정점으로의 최단 경로를 구한다.
 * : O(n) = n^3
 */
public class 플로이드 {

    static final int INF = 987654321;
    static int numOfCities;
    static int numOfBuses;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        promptFromUserInput();
        floydWarshall();
        displayResult();
    }

    private static void promptFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numOfCities = Integer.parseInt(br.readLine());
        numOfBuses = Integer.parseInt(br.readLine());
        graph = new int[numOfCities + 1][numOfCities + 1];

        initGraph();
        for (int i = 0; i < numOfBuses; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start][end] = Math.min(graph[start][end], cost);
        }
    }

    private static void initGraph() { // i == j인 경우는 0으로, 나머지는 INF로 초기화
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                graph[i][j] = i == j ? 0 : INF;
            }
        }
    }

    private static void floydWarshall() {
        for (int i = 1; i <= numOfCities; i++) {
            for (int j = 1; j <= numOfCities; j++) {
                for (int k = 1; k <= numOfCities; k++) {
                    if (graph[j][k] > graph[j][i] + graph[i][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }
    }

    private static void displayResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                sb.append(graph[i][j] == INF ? 0 : graph[i][j]).append(" "); // 갈 수 없는 경로인 경우 0으로 출력
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
