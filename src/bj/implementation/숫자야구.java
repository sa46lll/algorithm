package bj.implementation;

import java.util.*;

public class 숫자야구 {

    static int n;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][3];
        int result = 0;

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        for (int i = 111; i < 999; i++) {
            int[] p1 = {i / 100, i / 10 % 10, i % 10};
            if (!check(p1)) {
                continue;
            }
            int count = 0;
            for (int[] a : arr) {
                int[] p2 = {a[0] / 100, a[0] / 10 % 10, a[0] % 10};
                if (getStrike(p1, p2) == a[1] && getBall(p1, p2) == a[2]) {
                    count++;
                }
            }
            if (count == n) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean check(int[] places) {
        if (places[0] == 0 || places[1] == 0 || places[2] == 0) {
            return false;
        }
        return places[0] != places[1] && places[0] != places[2] && places[1] != places[2];
    }

    private static int getStrike(int[] p1, int[] p2) {
        int strike = 0;
        if (p1[0] == p2[0]) {
            strike++;
        }
        if (p1[1] == p2[1]) {
            strike++;
        }
        if (p1[2] == p2[2]) {
            strike++;
        }
        return strike;
    }

    private static int getBall(int[] p1, int[] p2) {
        int ball = 0;
        if (p1[0] == p2[1] || p1[0] == p2[2]) {
            ball++;
        }
        if (p1[1] == p2[0] || p1[1] == p2[2]) {
            ball++;
        }
        if (p1[2] == p2[0] || p1[2] == p2[1]) {
            ball++;
        }
        return ball;
    }
}
