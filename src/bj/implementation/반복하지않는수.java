package bj.implementation;

import java.util.*;

public class 반복하지않는수 {

    static int[] arr = new int[1_000_010];
    static int[] count = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        init();

        while (n != 0) {
            System.out.println(arr[n]);
            n = sc.nextInt();
        }
    }

    private static void init() {
        int n = 1;
        for (int i = 1; i < arr.length; i++) {
            while (true) {
                if (!check(n)) {
                    n++;
                    continue;
                }
                break;
            }
            arr[i] = n;
            n++;
        }
    }

    private static boolean check(int n) {
        initCount();

        while (n > 0) {
            int temp = n % 10;
            count[temp]++;
            n /= 10;

            if (count[temp] > 1) {
                return false;
            }
        }
        return true;
    }

    private static void initCount() {
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
    }
}
