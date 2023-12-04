package bj.number_theory;

import java.util.*;

public class 청기백기 {

    public static void main(String[] args) {
        new 청기백기().solution();
    }

    private void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            count++;
        }
        System.out.println(count);
    }
}
