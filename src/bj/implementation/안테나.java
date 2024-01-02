package bj.implementation;

import java.util.*;

public class 안테나 {

    static List<Integer> nList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            nList.add(sc.nextInt());
        }

        Collections.sort(nList);

        if (n % 2 == 1) {
            System.out.println(nList.get(n / 2));
            return;
        }

        if (check(n / 2 - 1) <= check(n / 2)) {
            System.out.println(nList.get(n / 2 - 1));
            return;
        }

        System.out.println(nList.get(n / 2));
    }

    private static int check(int idx) {
        int sum = 0;
        int n = nList.get(idx);
        for (int a : nList) {
            sum += Math.abs(a - n);
        }
        return sum;
    }
}
