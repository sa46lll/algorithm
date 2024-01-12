package bj.number_theory;

import java.util.*;

public class 소수의자격 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();
        int count = 0;

        for (int i = a; i <= b; i++) {
            if (isContain(i, d) && isPrime(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isContain(int a, int d) {
        while (a > 0) {
            if (a % 10 == d) {
                return true;
            }
            a /= 10;
        }
        return false;
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
