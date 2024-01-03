package bj.implementation;

import java.util.*;

public class 편의점2 {

    static List<Integer> dx = new ArrayList<>();
    static List<Integer> dy = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            dx.add(sc.nextInt());
            dy.add(sc.nextInt());
        }

        Collections.sort(dx);
        Collections.sort(dy);

        if (n % 2 == 1) {
            System.out.println(checkX(n / 2) + checkY(n / 2));
            return;
        }
        long i = Math.min(checkX(n / 2 - 1), checkX(n / 2));
        long j = Math.min(checkY(n / 2 - 1), checkY(n / 2));
        System.out.println(i + j);
    }

    private static long checkX(int idx) {
        long sum = 0;
        for (int i = 0; i < dx.size(); i++) {
            sum += (Math.abs(dx.get(i) - dx.get(idx)));
        }
        return sum;
    }

    private static long checkY(int idx) {
        long sum = 0;
        for (int i = 0; i < dx.size(); i++) {
            sum += (Math.abs(dy.get(i) - dy.get(idx)));
        }
        return sum;
    }
}
