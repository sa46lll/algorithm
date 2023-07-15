package bj.binarysearch;

import java.util.*;

public class 나무자르기 {

    static int max = 0;

    static void solution(int m, int[] trees) {
        int result = 0;
        int left = 0;
        int right = max;
        while (left <= right) {
            long sum = 0;
            int mid = (left + right) / 2;
            for (int tree : trees) {
                long remainTree = tree - mid;
                if (remainTree > 0) {
                    sum += remainTree;
                }
            }
            if (sum >= m) {
                result = Math.max(mid, result);
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = scanner.nextInt();
            max = Math.max(max, trees[i]);
        }
        solution(m, trees);
    }
}
