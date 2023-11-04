package bj.implementation;

import java.util.*;

public class 수정렬하기 {

    private int[] naturals;

    public static void main(String[] args) {
        new 수정렬하기().solution();
    }

    private void solution() {
        initializeFromUserInput();
        Arrays.sort(naturals);
        printResult();
    }

    private void initializeFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        naturals = new int[n];
        for (int i = 0; i < naturals.length; i++) {
            naturals[i] = scanner.nextInt();
        }
    }

    private void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i : naturals) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
