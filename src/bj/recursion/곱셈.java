package bj.recursion;

import java.io.*;
import java.util.*;

/**
 * 1) a * b % c = (a % c) * (b % c)
 * 2) a^11 % c = (a^5 % c) * (a^5 % c) * (a % c) = (a^2 % c) * (a^2 % c) * (a^2 % c) * (a^2 % c) * (a % c) = ...
 */
public class 곱셈 {

    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        long result = recursiveModuler(a, b);

        System.out.println(result);
    }

    private static long recursiveModuler(long a, long n) {
        if (n == 1) {
            return a % c;
        }

        long temp = recursiveModuler(a, n / 2);

        if (n % 2 != 0) {
            return temp % c * temp % c * a % c;
        }

        return temp * temp % c;
    }
}
