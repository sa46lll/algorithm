package bj.bruteforce;

import java.util.*;

public class 연세대학교프로그래밍경시대회 {

    private int candyCount;
    private int result = 0;

    public static void main(String[] args) {
        new 연세대학교프로그래밍경시대회().solution();
    }

    private void solution() {
        getUserInput();
        for (int i = 1; i <= 100; i++) { // 남규
            for (int j = 1; j <= 100; j++) { // 영훈
                for (int k = 1; k <= 100; k++) { // 택희
                    if (i + j + k != candyCount) {
                        continue;
                    }
                    if (k % 2 == 1) {
                        continue;
                    }
                    if (i - j < 2) {
                        continue;
                    }
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        candyCount = scanner.nextInt();
    }
}
