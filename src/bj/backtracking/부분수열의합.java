package bj.backtracking;

import java.util.*;

/**
 * 조합(3)
 */
public class 부분수열의합 {

    static int n;
    static int s;
    static int[] arr;
    static int[] sequence;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];
        sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
        }

        recur(0, 0, 0);

        System.out.println(s == 0 ? count - 1 : count);
    }

    private static void recur(int cur, int start, int sum) {
        if (sum == s) {
            count++;
        }
        if (cur == n) {
            return;
        }
        for (int i = start; i < n; i++) {
            int k = sequence[i];
            arr[cur] = k;
            recur(cur + 1, i + 1, sum + k);
            arr[cur] = 0;
        }
    }
}
