package bj.backtracking;

import java.util.*;

public class N과M_2 {

    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        recur(0, 1);
    }

    private static void recur(int cur, int start) {
        if (cur == m) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[cur] = i;
            recur(cur + 1, i + 1);
        }
    }
}
