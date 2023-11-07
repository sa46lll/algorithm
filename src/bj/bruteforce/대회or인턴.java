package bj.bruteforce;

import java.util.Scanner;

public class 대회or인턴 {

    private int n;
    private int m;
    private int k;

    public static void main(String[] args) {
        new 대회or인턴().solution();
    }

    private void solution() {
        getUserInput();
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m; j++) {
                if (i + j + k > n + m) {
                    continue;
                }
                max = Math.max(max, Math.min(i / 2, j));
            }
        }
        System.out.println(max);
    }

    private void getUserInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
    }
}
