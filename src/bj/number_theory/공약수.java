package bj.number_theory;

import java.util.*;

public class 공약수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int min = n + m;
        int[] result = {n, m};

        for (int i = 2; i < m; i++) {
            if (m % i != 0) {
                continue;
            }
            int x = n * i;
            int y = m / i;
            if (x > y) {
                break;
            }

            if (gcd(y, x) != n) {
                continue;
            }

            if (x + y < min) {
                min = x + y;
                result = new int[]{x, y};
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }

    private static int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}
