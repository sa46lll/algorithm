package bj.twopointer;

import java.util.*;

public class 소수의연속합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> way = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                way.add(i);
            }
        }
        way.add(0);

        int s = 0;
        int e = -1;
        int sum = 0;
        int count = 0;
        while (e < way.size() - 1) {
            if (sum > n) { // 합이 크면 구간을 좁힌다
                sum -= way.get(s);
                s++;
                continue;
            }
            if (sum < n) { // 합이 작으면 구간을 넓힌다
                e++;
                sum += way.get(e);
                 continue;
            }
            sum -= way.get(s);
            s++;
            e++;
            sum += way.get(e);
            count++;
        }

        System.out.println(count);
    }
}
