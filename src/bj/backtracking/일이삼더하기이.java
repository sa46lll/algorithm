package bj.backtracking;

import java.util.*;

/**
 * 중복 순열
 */
public class 일이삼더하기이 {

    static int n;
    static int k;
    static int[] nums = {1, 2, 3};
    static int[] arr;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n + 1];

        recur(0, 0);

        System.out.println(sb.length() == 0 ? -1 : sb);
    }

    private static void recur(int cur, int sum) {
        if (sum == n) {
            count++;
            if (count == k) {
                saveResult(arr);
                return;
            }
        }
        if (sum > n) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            arr[cur] = k;
            recur(cur + 1, sum + k);
            arr[cur] = 0;
        }
    }

    private static void saveResult(int[] arr) {
        int idx = 0;
        while (arr[idx] != 0) {
            sb.append(arr[idx]).append("+");
            idx++;
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}
