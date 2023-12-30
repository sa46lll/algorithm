package bj.backtracking;

import java.util.Scanner;

public class N과M_1 {

    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        visited = new boolean[n + 1];
        recur(0);
    }

    private static void recur(int cur) {
        if (cur == m) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[cur] = i;
            recur(cur + 1);
            visited[i] = false;
        }
    }
}
