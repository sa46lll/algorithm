package bj.implementation;

import java.util.*;

public class 한수 {

    private int n;

    public static void main(String[] args) {
        new 한수().solution();
    }

    private void solution() {
        getUserInput();

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!isHanSoo(i)) {
                continue;
            }
            result++;
        }
        System.out.println(result);
    }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
    }

    private boolean isHanSoo(int i) {
        int onesPlace = i % 10;
        int tensPlace = (i / 10) % 10;
        int diff = tensPlace - onesPlace;
        int diff2;
        while (i != 0) {
            diff2 = tensPlace - onesPlace;
            if (diff != diff2) {
                return false;
            }
            onesPlace = i % 10;
            tensPlace = (i / 10) % 10;
            i /= 10;
        }
        return true;
    }
}
