package bj.implementation;

import java.util.*;

public class 거스름돈 {

    private static int[] changes = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = calculateChange(1000 - sc.nextInt());
        System.out.println(result);
    }

    private static int calculateChange(int money) {
        int m = money;
        int index = 0;
        int count = 0;
        while (m != 0) {
            count += m / changes[index];
            m %= changes[index];
            index++;
        }
        return count;
    }
}
