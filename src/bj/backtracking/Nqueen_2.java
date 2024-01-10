package bj.backtracking;

import java.util.Scanner;

public class Nqueen_2 {

    static int n;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        recur(0);

        System.out.println(count);
    }

    private static void recur(int cur) {
        if (cur == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[cur] = i;
            if (!check(cur)) {
                continue;
            }
            recur(cur + 1);
        }
    }

    private static boolean check(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[i] == arr[col]) {
                return false;
            }

            if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
