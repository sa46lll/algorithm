package bj.implementation;

import java.util.*;

public class 피보나치5_2 {

    private int n;

    public static void main(String[] args) {
        new 피보나치5_2().solution();
    }

    private void solution() {
        getUserInput();
        int result = fibonacci(n);
        System.out.println(result);
    }

    private void getUserInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }

    private int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
