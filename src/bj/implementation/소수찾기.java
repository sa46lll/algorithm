package bj.implementation;

import java.io.*;

public class 소수찾기 {

    private static int m;
    private static int n;
    private static int min = Integer.MAX_VALUE;
    private static int sum;

    public static void main(String[] args) throws IOException {
        getUserInput();

        for (int i = m; i <= n; i++) {
            if (isPrimeNumber(i)) {
                sum += i;
                min = Math.min(min, i);
            }
        }
        printResult();
    }

    private static void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
    }

    private static boolean isPrimeNumber(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void printResult() {
        if (sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }
}
