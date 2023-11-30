package bj.number_theory;

import java.util.*;

public class 이로몇번나누어질까 { // 미완

    private static long n;
    private static long m;

    public static void main(String[] args) {
        getUserInput();
        int result = 0;
        for (long i = n; i <= m; i++) {
            result += getMaxDivider(i);
        }
        System.out.println(result);
    }

    private static void getUserInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        m = sc.nextLong();
    }

    private static int getMaxDivider(long n) {
        if (n % 2 != 0) {
            return 1;
        }
        int multiple = 1;
        while (n % 2 == 0) {
            n /= 2;
            multiple *= 2;
        }
        return multiple;
    }
}
