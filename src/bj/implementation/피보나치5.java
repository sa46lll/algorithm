package bj.implementation;

import java.util.*;

public class 피보나치5 {

    private int n;
    private int result = 0;

    public static void main(String[] args) {
        new 피보나치5().solution();
    }

    private void solution() {
        getUserInput();
        fibonacci(0, 1, 2);
        System.out.println(result);
    }

    private void getUserInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }

    private void fibonacci(int n1, int n2, int depth) {
        if (depth == n) {
            result = n1 + n2;
            return;
        }
        System.out.println("n1 = " + n1);
        fibonacci(n2, n1 + n2, depth + 1);
    }
}
