package bj.twopointer;

import java.io.*;
import java.util.*;

public class 용액 {

    static void solution(int[] solutions) {
        Arrays.sort(solutions);

        int result = Integer.MAX_VALUE;
        int[] resultSolution = new int[2];

        int left = 0;
        int right = solutions.length - 1;
        while (left < right) {
            int sum = solutions[left] + solutions[right];
            if (Math.abs(sum) < result) {
                result = Math.abs(sum);
                resultSolution[0] = solutions[left];
                resultSolution[1] = solutions[right];
            }
            if (sum > 0) {
                right--;
                continue;
            }
            left++;
        }
        System.out.println(String.format("%d %d", resultSolution[0], resultSolution[1]));
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] solutions = new int[n];
        for (int i = 0; i < n; i++) {
            solutions[i] = scanner.nextInt();
        }
        solution(solutions);
    }
}
