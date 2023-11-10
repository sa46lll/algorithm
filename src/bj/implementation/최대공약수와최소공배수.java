package bj.implementation;

import java.util.*;

public class 최대공약수와최소공배수 {

    private int n; // 작은수
    private int m; // 큰수

    public static void main(String[] args) {
        new 최대공약수와최소공배수().solution();
    }

    private void solution() {
        Scanner sc = new Scanner(System.in);
        int temp1 = sc.nextInt();
        int temp2 = sc.nextInt();
        if (temp1 < temp2) {
            n = temp1;
            m = temp2;
        } else {
            n = temp2;
            m = temp1;
        }

        int gcd = getGcd();
        int lcm = getLcm();
        System.out.println(gcd);
        System.out.println(lcm);
    }

    private int getGcd() {
        for (int i = n; i >= 2; i--) {
            if (n % i == 0 && m % i == 0) {
                return i;
            }
        }
        return 1;
    }

    private int getLcm() {
        for (int i = m; i <= n * m; i++) {
            if (i % m == 0 && i % n == 0) {
                return i;
            }
        }
        return n * m;
    }
}
