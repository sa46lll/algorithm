package bj.bruteforce;

import java.util.*;

public class 통학의신 {

    private int a;
    private int b;

    public static void main(String[] args) {
        new 통학의신().solution();
    }

    private void solution() {
        getFromUserInput();
        calculate(a, b);
    }

    private void getFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
    }

    private void calculate(int a, int b) {
        for (int i = -1000; i <= 1000; i++) {
            if (i * i + 2 * i * a + b != 0) {
                continue;
            }
            System.out.print(i + " ");
        }
    }
}
