package bj.implementation;

import java.util.*;

public class 대표값2 {

    private static int sum = 0;
    private static int[] arr;

    public static void main(String[] args) {
        getUserInput();
        Arrays.sort(arr);
        int average = sum / arr.length;
        int mid = arr[arr.length / 2];
        System.out.println(average + "\n" + mid);
    }

    private static void getUserInput() {
        Scanner sc = new Scanner(System.in);
        arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
    }
}
