package bj.backtracking;

import java.util.*;

public class N과M2 {

    private int n;
    private int m;
    private int[] uniqueNumbers;
    private final StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        new N과M2().solution();
    }

    private void solution() {
        initializeFromUserInput();
        generatePermutations(1, 0);
        System.out.println(result);
    }

    private void generatePermutations(int startIndex, int depth) {
        if (depth == m) {
            for (int i = 0; i < uniqueNumbers.length; i++) {
                result.append(uniqueNumbers[i]).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            uniqueNumbers[depth] = i;
            generatePermutations(i + 1, depth + 1);
        }
    }

    private void initializeFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        uniqueNumbers = new int[m];
    }
}
