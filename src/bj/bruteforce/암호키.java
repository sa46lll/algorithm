package bj.bruteforce;

import java.util.*;

public class 암호키 {

    public static void main(String[] args) {
        new 암호키().solution();
    }

    private void solution() {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        int testCount = sc.nextInt();
        for (int i = 0; i < testCount; i++) {
            long n = sc.nextLong();
            if (isPrimeNumber(n)) {
                sb.append("YES").append("\n");
                continue;
            }
            sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    private boolean isPrimeNumber(long n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= 1000_000; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
