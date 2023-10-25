package bj.backtracking;

import java.util.*;

public class Nqueen {

    private int queenCount;
    private int[] positions; // index -> 행(row), value -> 열(col)
    private int numPossibilities; // 경우의 수

    public static void main(String[] args) {
        new Nqueen().solution();
    }

    private void solution() {
        initializeFromUserInput();
        dfs(0);
        System.out.println(numPossibilities);
    }

    private void initializeFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        queenCount = scanner.nextInt();
        positions = new int[queenCount];
    }

    private void dfs(int depth) {
        if (depth == queenCount) {
            numPossibilities++;
            return;
        }
        for (int i = 0; i < queenCount; i++) {
            positions[depth] = i;
            if (!isAttackPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private boolean isAttackPossible(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 있는지 확인
            if (positions[i] == positions[row]) {
                return true;
            }
            // 대각선에 있는지 확인
            if (Math.abs(row - i) == Math.abs(positions[row] - positions[i])) {
                return true;
            }
        }
        return false;
    }
}
