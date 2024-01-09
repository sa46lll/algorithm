package bj.implementation;

import java.util.*;

public class 창고다각형 {

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[1010];
        int[] prefixSum = new int[1010];
        int[] suffixSum = new int[1010];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[sc.nextInt()] = sc.nextInt();
        }

        for (int i = 1; i <= 1000; i++) {
            prefixSum[i] = Math.max(arr[i], prefixSum[i - 1]);
        }

        for (int i = 1000; i > 0; i--) {
            suffixSum[i] = Math.max(arr[i], suffixSum[i + 1]);
        }

        for (int i = 1; i <= 1000; i++) {
            sum += Math.min(prefixSum[i], suffixSum[i]);
        }

        System.out.println(sum);
    }
}
