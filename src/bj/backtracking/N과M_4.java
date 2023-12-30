package bj.backtracking;

import java.util.Scanner;

public class N과M_4 {

    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        recur(0, 1);
        System.out.println(sb);
    }

    private static void recur(int cur, int start) {
        if (cur == m) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[cur] = i;
            recur(cur + 1, i);
        }
    }
}
