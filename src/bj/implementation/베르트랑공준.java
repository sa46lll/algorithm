package bj.implementation;

import java.util.*;

public class 베르트랑공준 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            int count = 0;
            for (int i = n + 1; i <= n * 2; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
