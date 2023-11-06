package bj.implementation;

import java.util.*;

public class 벌집 {

    private int n;

    public static void main(String[] args) {
        new 벌집().solution();
    }

    private void solution() {
        getUserInput();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int room = 1;
        int plusRoom = 6;
        int floor = 1;
        while (true) {
            room += plusRoom;
            floor++;
            if (n <= room) {
                System.out.println(floor);
                return;
            }
            plusRoom += 6;
        }
    }

    private void getUserInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
    }
}
