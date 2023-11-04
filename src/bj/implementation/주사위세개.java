package bj.implementation;

import java.util.Scanner;

public class 주사위세개 {

    private int[] dice = new int[7];

    public static void main(String[] args) {
        new 주사위세개().solution();
    }

    private void solution() {
        initializeFromUserInput();
        int commonCount = 0;
        int max = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] >= commonCount) {
                commonCount = dice[i];
                max = i;
            }
        }
        int reward = 0;
        switch(commonCount) {
            case 1: {
                reward = max * 100;
                break;
            }
            case 2: {
                reward = 1000 + max * 100;
                break;
            }
            case 3: {
                reward = 10000 + max * 1000;
            }
        }
        System.out.println(reward);
    }

    private void initializeFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0 ; i < 3; i ++) {
            dice[scanner.nextInt()] += 1;
        }
    }
}
