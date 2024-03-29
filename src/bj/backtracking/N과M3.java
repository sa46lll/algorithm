package bj.backtracking;

import java.util.*;

public class N과M3 {

    private int n;
    private int m;
    private int[] sequence;
    private final StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        new N과M3().solution();
    }

    private void solution() {
        initializeFromUserInput();
        dfs(0);
        System.out.println(result);
    }

    private void dfs(int depth) {
        if (depth == m) {
            for (int s : sequence) {
                result.append(s).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            sequence[depth] = i;
            dfs(depth + 1);
        }
    }

    private void initializeFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        sequence = new int[m];
    }
}
