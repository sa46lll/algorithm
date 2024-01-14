package bj.number_theory;

import java.util.*;

public class 환상의짝꿍 {

    static final String YES = "YES";
    static final String NO = "NO";
    static boolean[] isPrime = new boolean[2_000_000];
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        init();

        while (testCount-- > 0) {
            long x = sc.nextLong() + sc.nextLong();

            if (x < 4) {
                sb.append(NO).append("\n");
                continue;
            }

            // 골드 바흐의 추측
            if (x % 2 == 0) {
                sb.append(YES).append("\n");
                continue;
            }

            sb.append(isPrime(x - 2) ? YES : NO).append("\n");
        }

        System.out.println(sb);
    }

    // 에라토스테네스의 체
    private static void init() {
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i]) {
                continue;
            }
            primes.add(i);
            for (long j = (long) i * i; j < isPrime.length; j += i) {
                isPrime[(int) j] = false;
            }
        }
    }

    private static boolean isPrime(long n) {
        if (n < 2_000_000) {
            return isPrime[(int) n];
        }
        for (int i : primes) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
