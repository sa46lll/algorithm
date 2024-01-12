package bj.number_theory;

import java.util.*;

public class 소수인팰린드롬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = a; i <= b; i++) {
            if (isPelindrom(i) && isPrime(i)) {
                sb.append(i).append("\n");
            }
        }
        sb.append(-1);

        System.out.println(sb);
    }

    private static boolean isPelindrom(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
