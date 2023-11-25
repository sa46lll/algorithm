package bj.implementation;

import java.util.*;

public class 초콜릿자르기 {

    public static void main(String[] args) {
        new 초콜릿자르기().solution();
    }

    private void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(Math.max(getCount(n, m), getCount(m, n)));
    }

    private int getCount(int x, int y) {
        return x - 1 + x * (y - 1);
    }
}
