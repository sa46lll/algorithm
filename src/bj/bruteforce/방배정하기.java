package bj.bruteforce;

import java.util.*;

public class 방배정하기 {

    private int[] room;
    private int students;

    public static void main(String[] args) {
        new 방배정하기().solution();
    }

    private void solution() {
        getUserInput();
        for (int i = 0; i <= 300; i++) {
            for (int j = 0; j <= 300; j++) {
                for (int k = 0; k <= 300; k++) {
                    if (i * room[0] + j * room[1] + k * room[2] == students) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    private void getUserInput() {
        Scanner sc = new Scanner(System.in);
        room = new int[3];
        for (int i = 0; i < room.length; i++) {
            room[i] = sc.nextInt();
        }
        students = sc.nextInt();
    }
}
