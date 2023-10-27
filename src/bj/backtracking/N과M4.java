package bj.backtracking;

import java.util.*;

public class N과M4 {

    private int n;
    private int m;
    private int[] sequence; // 현재 순열
    private final StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        new N과M4().solution();
    }

    private void solution() {
        initializeFromUserInput();
        generateSequence(1, 0);
        System.out.println(result);
    }

    private void generateSequence(int startIndex, int depth) {
        if (depth == m) {
            for (int i : sequence) {
                result.append(i).append(" ");
            }
            result.append("\n");
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            sequence[depth] = i;
            generateSequence(i, depth + 1);
        }
    }

    private void initializeFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        sequence = new int[m];
    }
}
