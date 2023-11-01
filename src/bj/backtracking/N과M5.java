package bj.backtracking;

import java.util.*;

public class N과M5 {

    private int n;
    private int m;
    private int[] sequence;
    private int[] nowVisited;
    private boolean[] visited;
    private final StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        new N과M5().solution();
    }

    private void solution() {
        initializeFromUserInput();
        Arrays.sort(sequence);
        generateSequence(0);
        System.out.println(result);
    }

    private void generateSequence(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                result.append(nowVisited[i]).append(" ");
            }
            result.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nowVisited[depth] = sequence[i];
                generateSequence(depth + 1);
                visited[i] = false;
            }
        }
    }

    private void initializeFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        sequence = new int[n];
        visited = new boolean[n];
        nowVisited = new int[m];
        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }
    }
}
