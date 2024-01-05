package bj.backtracking;

import java.util.*;

/**
 * 순열(중복x, 방문 처리) (2)
 */
public class 부등호 {

    static int n;
    static long[] arr;
    static String[] signs;
    static boolean[] visited = new boolean[10];
    static long min = Long.MAX_VALUE;
    static long max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new long[n + 1];
        signs = new String[n];
        for (int i = 0; i < n; i++) {
            signs[i] = sc.next();
        }

        recur(0);

        System.out.printf("%0" + (n + 1) + "d%n", max);
        System.out.printf("%0" + (n + 1) + "d", min);
    }

    private static void recur(int cur) {
        if (cur == n + 1) {
            if (!check(arr)) {
                return;
            }
            long j = 0;
            int k = 1;
            for (int i = arr.length - 1; i >= 0; i--) {
                j += arr[i] * k;
                k *= 10;
            }
            min = Math.min(min, j);
            max = Math.max(max, j);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                continue;
            }
            arr[cur] = i;
            visited[i] = true;
            recur(cur + 1);
            visited[i] = false;
        }
    }

    private static boolean check(long[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] < arr[i + 1] && "<".equals(signs[i])) || (arr[i] > arr[i + 1] && ">".equals(signs[i]))) {
                continue;
            }
            return false;
        }
        return true;
    }
}
