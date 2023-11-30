package bj.dynamic;

import java.util.*;

public class 이n타일링 {

    public static void main(String[] args) {
        new 이n타일링().solution();
    }

    private void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cases = dp(n);
        System.out.println(cases);
    }

    private int dp(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int[] dpArr = new int[n + 1];
        dpArr[2] = 2;
        dpArr[3] = 3;
        for (int i = 4; i < n + 1; i++) {
            dpArr[i] = (dpArr[i - 1] + dpArr[i - 2]) % 10007;
        }
        return dpArr[n];
    }
}
