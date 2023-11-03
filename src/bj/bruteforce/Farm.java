package bj.bruteforce;

import java.util.*;

public class Farm {

    private int a;
    private int b;
    private int n;
    private int w;

    public static void main(String[] args) {
        new Farm().solution();
    }

    private void solution() {
        getUserInput();

        int count = 0;
        int[] animalCount = new int[2];
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                if (i + j != n) {
                    continue;
                }
                if (i * a + j * b != w) {
                    continue;
                }
                count++;
                animalCount[0] = i;
                animalCount[1] = j;
            }
        }
        if (count != 1) {
            System.out.println(-1);
            return;
        }
        System.out.println(animalCount[0] + " " + animalCount[1]);
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        n = scanner.nextInt();
        w = scanner.nextInt();
    }
}
