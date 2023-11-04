package bj.implementation;

import java.util.*;

public class 오븐시계 {

    private int hour;
    private int minute;
    private int minutesToCook;

    public static void main(String[] args) {
        new 오븐시계().solution();
    }

    private void solution() {
        initializeFromUserInput();
        int finishHour = hour;
        int finishMinute = minute + minutesToCook;
        if (finishMinute >= 60) {
            finishHour += finishMinute / 60;
            finishMinute %= 60;
        }
        if (finishHour >= 24) {
            finishHour -= 24;
        }
        System.out.print(finishHour + " " + finishMinute);
    }

    private void initializeFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        hour = scanner.nextInt();
        minute = scanner.nextInt();
        minutesToCook = scanner.nextInt();
    }
}
