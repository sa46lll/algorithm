package bj.twopointer;

import java.io.*;
import java.util.*;

public class 용액2 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] solutions = new int[n];
        int difference = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 0; i < n; i++) {
            solutions[i] = scanner.nextInt();
        }

        int s = 0;
        int e = solutions.length - 1;
        while (s < e) {
            int abs = Math.abs(solutions[s] + solutions[e]);
            if (abs < difference) {
                difference = abs;
                result = new int[]{solutions[s], solutions[e]};
            }
            if (solutions[s] + solutions[e] < 0) { // 값이 작으면 왼쪽을 버림
                s++;
                continue;
            }
            if (solutions[s] + solutions[e] > 0) { // 값이 크면 오른쪽을 버림
                e--;
                continue;
            }
            result = new int[]{solutions[s], solutions[e]};
            break;
        }

        System.out.println(String.format("%d %d", result[0], result[1]));
    }
}
