package bj.number_theory;

import java.util.*;

public class 이로몇번나누어질까 {

    private static long n;
    private static long m;

    public static void main(String[] args) {
        getUserInput();

        long sum = m - n + 1 - (m / 2 - (n - 1) / 2); // 홀수 개수
        for (long i = 2; i <= m; i *= 2) {
            long count = (m / i - (n - 1) / i) - (m / (i * 2) - (n - 1) / (i * 2)); // i의 배수 개수 - (i * 2)의 배수 개수
            sum += count * i;
        }

        System.out.println(sum);
    }

    private static void getUserInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        m = sc.nextLong();
    }
}
