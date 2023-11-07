package bj.bruteforce;

import java.util.*;

public class 완전제곱수 {

    private int n;

    public static void main(String[] args) {
        new 완전제곱수().solution();
    }

    private void solution() {
        getUserInput();
        int count = 0;
        for (int b = 1; b <= 500; b++) {
            for (int a = b; a <= 500; a++) {
                if (b * b + n == a * a) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private void getUserInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }
}
