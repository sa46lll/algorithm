package bj.implementation;

import java.util.*;

public class 세수 {

    private int[] n;

    public static void main(String[] args) {
        new 세수().solution();
    }

    private void solution() {
        getUserInput();
        Arrays.sort(n);
        System.out.println(n[1]);
    }

    private void getUserInput() {
        n = new int[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n.length; i++) {
            n[i] = sc.nextInt();
        }
    }
}
