package bj.graph;

import java.io.*;
import java.util.*;

/**
 * 플로이드 연산 (floyd-warshall)
 * : 모든 정점에서 모든 정점으로의 최단 경로를 구한다.
 */
public class 회장뽑기 {

    private static final int INF = 987654321;
    private static int[][] graph;
    private static int numOfMembers;
    private static int SCORE_MIN = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numOfMembers = Integer.parseInt(br.readLine());
        graph = new int[numOfMembers][numOfMembers];

        initGraph();
        fillGraph(br);

        floydWarshall();
        int[] scores = calculateScore();
        displayResult(scores);
    }

    private static void initGraph() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = i == j ? 0 : INF;
            }
        }
    }

    private static void fillGraph(BufferedReader br) throws IOException {
        String line = br.readLine();
        while (!"-1 -1".equals(line)) {
            StringTokenizer st = new StringTokenizer(line);
            int member1 = Integer.parseInt(st.nextToken()) - 1;
            int member2 = Integer.parseInt(st.nextToken()) - 1;
            graph[member1][member2] = 1;
            graph[member2][member1] = 1;
            line = br.readLine();
        }
    }

    private static void floydWarshall() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph.length; k++) {
                    if (graph[j][k] > graph[i][k] + graph[j][i]) {
                        graph[j][k] = graph[i][k] + graph[j][i];
                    }
                }
            }
        }
    }

    private static int[] calculateScore() {
        int[] scores = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            int max = 0;
            for (int j = 0; j < graph.length; j++) {
                if (i == j) {
                    continue;
                }
                max = Math.max(max, graph[i][j]);
            }
            scores[i] = max;
            SCORE_MIN = Math.min(SCORE_MIN, max);
        }
        return scores;
    }

    private static void displayResult(int[] scores) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == SCORE_MIN) {
                count++;
                sb.append(i + 1).append(" ");
            }
        }
        System.out.printf("%d %d\n", SCORE_MIN, count);
        System.out.print(sb);
    }
}
