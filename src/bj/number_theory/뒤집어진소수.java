package bj.number_theory;

import java.util.*;

public class 뒤집어진소수 {

    private int[] reverses = {0, 1, 2, -1, -1, 5, 9, -1, 8, 6}; // 뒤집히면 바뀌는 수

    public static void main(String[] args) {
        new 뒤집어진소수().solution();
    }

    private void solution() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if (validate(n) && isPrime(n) && isPrime(getReverse(n))) {
            System.out.println("yes");
            return;
        }
        System.out.println("no");
    }

    private boolean validate(long n) {
        while (n > 0) {
            int temp = (int) (n % 10);
            if (reverses[temp] == -1) return false;
            n /= 10;
        }
        return true;
    }

    private int getReverse(long n) {
        Queue<Integer> queue = new LinkedList<>();
        while (n > 0) {
            queue.add((int) (n % 10));
            n /= 10;
        }
        int reverse = 0;
        while (!queue.isEmpty()) {
            int m = queue.poll();
            reverse += reverses[m] * Math.pow(10, queue.size());
        }
        return reverse;
    }

    private boolean isPrime(long n) {
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
}
