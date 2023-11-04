package bj.implementation;

import java.util.Scanner;

public class 더하기사이클 {

    private int n;

    public static void main(String[] args) {
        new 더하기사이클().solution();
    }

    private void solution() {
        initializeFromUserInput();
        int m = n;
        int count = 0;
        while (true) {
            int tensPlace = m / 10;
            int onesPlace = m % 10;

            int newNatural = (tensPlace + onesPlace) % 10;
            m = onesPlace * 10 + newNatural;
            count++;
            if (n == m) {
                break;
            }
        }
        System.out.println(count);
    }

    private void initializeFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
    }
}
