package bj.backtracking;

import java.util.*;

public class N과M {

    private int n;
    private int m;
    private int[] uniqueNumbers; // 중복되지 않는 숫자들 모임 (방문한 숫자 모임)
    private boolean[] visited; // 기존 숫자 방문 여부
    private StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        new N과M().solution();
    }

    private void solution() {
        initializeFromUserInput();
        generatePermutations(0);
        System.out.println(result);

    }

    private void generatePermutations(int depth) {
        if (depth == m) {
            for (int i = 0; i < uniqueNumbers.length; i++) {
                result.append(uniqueNumbers[i]).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                uniqueNumbers[depth] = i;
                generatePermutations(depth + 1);
                visited[i] = false;
            }
        }
    }

    private void initializeFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        uniqueNumbers = new int[m];
        visited = new boolean[n + 1];
    }
}
