package bj.number_theory;

import java.util.*;

public class 조합0의개수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long count2 = getCount2(n) - getCount2(m) - getCount2(n - m);
        long count5 = getCount5(n) - getCount5(m) - getCount5(n - m);

        System.out.println(Math.min(count2, count5));
    }

    private static long getCount2(int n) { // n!에 2가 몇 개 있는지
        long count = 0;
        for (long i = 2; i <= n; i *= 2) {
            count += n / i;
        }
        return count;
    }

    private static long getCount5(int n) {
        long count = 0;
        for (long i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
