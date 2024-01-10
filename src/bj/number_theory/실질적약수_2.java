package bj.number_theory;

import java.util.*;

public class 실질적약수_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;

        for (int i = 2; i <= n / 2; i++) {
            result += (n / i - 1) * i;
            result %= 1_000_000;
        }

        System.out.println(result);
    }
}
