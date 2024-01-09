package bj.implementation;

import java.util.*;

public class 아이폰9s {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }

        for (int i : set) {
            max = Math.max(max, calculate(i, arr));
        }

        System.out.println(max);
    }

    private static int calculate(int skip, int[] arr) {
        int max = 1;
        int count = 0;
        int before = -1;
        for (int i : arr) {
            if (i == skip) {
                continue;
            }
            if (before != i) {
                count = 1;
                before = i;
                continue;
            }
            count++;
            max = Math.max(max, count);
        }
        return max;
    }
}
