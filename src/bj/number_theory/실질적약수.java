package bj.number_theory;

import java.util.*;

public class 실질적약수 {

    public static void main(String[] args) {
        new 실질적약수().solution();
    }

    private void solution() {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            sum += (n / i) * i;
            sum -= i;
        }
        System.out.println(sum % 1_000_000);
    }
}
