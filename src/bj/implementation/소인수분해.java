package bj.implementation;

import java.util.*;

public class 소인수분해 {

    private int n;

    public static void main(String[] args) {
        new 소인수분해().solution();
    }

    private void solution() {
        getUserInput();
        if (n == 1) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            if (n == 1) {
                break;
            }
            if (n % i != 0) {
                continue;
            }
            sb.append(i).append("\n");
            n /= i--;
        }
        System.out.println(sb);
    }

    private void getUserInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }
}
