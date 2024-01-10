package bj.number_theory;

import java.util.*;

public class 뒤집어진소수_2 {

    static int[] opposite = {0, 1, 2, -1, -1, 5, 9, -1, 8, 6};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        if (!isPrime(n) || !check(n) || !isPrime(getOpposite(n))) {
            System.out.println("no");
            return;
        }
        System.out.println("yes");
    }

    private static boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean check(long n) {
        while (n > 0) {
            if (opposite[(int) (n % 10)] == -1) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    private static long getOpposite(long n) {
        Queue<Integer> queue = new LinkedList<>();
        int x = 0;

        while (n > 0) {
            queue.add((int) (n % 10));
            n /= 10;
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            x += opposite[poll] * Math.pow(10, queue.size());
        }

        return x;
    }
}
