package bj.number_theory;

import java.util.*;

public class 이로몇번나누어질까_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long result = 0;

        long x = a - 1;
        result += b - x - (b / 2 - x / 2); // 홀수 개수

        for (long i = 2; i <= b; i *= 2) {
            result += ((b / i - x / i) - (b / (i * 2) - x / (i * 2))) * i;
        }

        System.out.println(result);
    }
}
