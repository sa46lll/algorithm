package bj.backtracking;

import java.util.*;

public class 좋은수열 { // 미완

    static int n;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        recur(0);

        System.out.println(sb);
    }

    private static void recur(int cur) {
        if (cur == n) {
            if (!check(arr)) {
                return;
            }
            if (sb.length() == 0) {
                for (int a : arr) {
                    sb.append(a);
                }
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            arr[cur] = i;
            recur(cur + 1);
        }
    }

    private static boolean check(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < i - j; k++) {
                    if (i + k >= arr.length) {
                        break;
                    }
                    if (arr[j + k] != arr[i + k]) {
                        break;
                    }
                    if (j + k == i - 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
