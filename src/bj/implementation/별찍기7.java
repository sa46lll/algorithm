package bj.implementation;

import java.util.*;

public class 별찍기7 {

    private static int n;

    public static void main(String[] args) {
        getUserInput();
        printStar(n);
    }

    private static void getUserInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }

    private static void printStar(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                sb.append(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < i; k++) {
                sb.append(" ");
            }
            for (int j = 2 * n - 2 * i - 1; j > 0; j--) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
