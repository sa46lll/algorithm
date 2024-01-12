package bj.number_theory;

import java.util.*;

public class 팩토리얼나누기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long a = sc.nextInt();
        long count = 0;

        for (long i = a; i <= n; i *= a) {
            count += n / i;
        }

        System.out.println(count);
    }
}
