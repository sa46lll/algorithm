package bj.backtracking;

import java.util.*;

public class 차이를최대로 {

    static int n;
    static int[] arr;
    static int[] nums;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        nums = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        recur(0);

        System.out.println(max);
    }

    private static void recur(int cur) {
        if (cur == n) {
            max = Math.max(max, calculate(arr));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[cur] = nums[i];
            recur(cur + 1);
            visited[i] = false;
        }
    }

    private static int calculate(int[] arr) {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }
        return sum;
    }
}
