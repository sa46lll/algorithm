package bj.sort;

import java.util.*;

public class 소트인사이드 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[Integer.toString(n).length()];

        int idx = 0;
        while (n > 0) {
            arr[idx++] = n % 10;
            n /= 10;
        }

        Arrays.sort(arr);
        printResult(arr);
    }

    private static void printResult(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[arr.length - i - 1]);
        }
        System.out.println(sb);
    }
}
