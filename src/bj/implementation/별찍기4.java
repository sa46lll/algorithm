package bj.implementation;

import java.util.*;

public class 별찍기4 {

    private int n;

    public static void main(String[] args) {
        new 별찍기4().solution();
    }

    private void solution() {
        getUserInput();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }
            for (int k = n - i; k > 0; k--) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private void getUserInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }
}
