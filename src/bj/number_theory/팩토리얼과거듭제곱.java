package bj.number_theory;

import java.util.*;

public class 팩토리얼과거듭제곱 {

    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (testCount-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long min = Long.MAX_VALUE;

            long copy = k;
            for (long i = 2; i * i <= k; i++) {
                while (copy % i == 0) {
                    map.put(i, map.getOrDefault(i, 0L) + 1);
                    copy /= i;
                }
            }

            if (copy != 1) {
                map.put(copy, map.getOrDefault(copy, 0L) + 1);
            }

            for (long i : map.keySet()) {
                long count = 0;
                long x = n / i;

                while (x > 0) {
                    count += x;
                    x /= i;
                }

                min = Math.min(min, count / map.get(i));
            }

            sb.append(min).append("\n");
            map.clear();
        }

        System.out.println(sb);
    }
}
