package pgm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;

    static int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];
        distance = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int[] ints : edge) {
            graph.get(ints[0]).add(ints[1]);
            graph.get(ints[1]).add(ints[0]);
        }
        return bfs();
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int q = queue.poll();
            for (int child : graph.get(q)) {
                if (!visited[child]) {
                    queue.add(child);
                    visited[child] = true;
                    distance[child] = distance[q] + 1;
                }
            }
        }
        int max = Arrays.stream(distance).max().getAsInt();
        int answer = 0;
        for (int d : distance) {
            if (d == max) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
