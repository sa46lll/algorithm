package bj.greedy;

import java.io.*;
import java.util.*;

public class 동전02 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int value = scanner.nextInt();
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = scanner.nextInt();
        }

        int idx = money.length - 1;
        int result = 0;
        while (value > 0) {
            int moneyUnit = money[idx--];
            if (moneyUnit > value) {
                continue;
            }
            result += value / moneyUnit;
            value %= moneyUnit;
        }
        System.out.println(result);
    }
}
