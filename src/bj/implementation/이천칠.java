package bj.implementation;

import java.util.*;

public class 이천칠 {

    private int month;
    private int day;
    private static final int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] week = new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public static void main(String[] args) {
        new 이천칠().solution();
    }

    private void solution() {
        getUserInput();
        int daysDifference = calculateDaysDifference(month, day);
        System.out.println(getDayOfWeek(daysDifference));
    }

    private void getUserInput() {
        Scanner sc = new Scanner(System.in);
        month = sc.nextInt();
        day = sc.nextInt();
    }

    private int calculateDaysDifference(int month, int day) {
        int dayCount = 0;
        for (int i = 1; i < month; i++) {
            dayCount += days[i];
        }
        return dayCount + day - 1;
    }

    private String getDayOfWeek(int days) {
        return week[days % 7];
    }
}
