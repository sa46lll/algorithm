package bj.implementation;

import java.io.*;
import java.util.*;

public class 공바꾸기 {

    private int changeCount;
    private int[] balls;

    public static void main(String[] args) throws IOException {
        new 공바꾸기().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        for (int i = 0; i < changeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index1 = Integer.parseInt(st.nextToken());
            int index2 = Integer.parseInt(st.nextToken());
            if (index1 == index2) {
                continue;
            }
            changeBall(index1, index2);
        }
        printBall();
    }

    private void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ballCount = Integer.parseInt(st.nextToken());
        changeCount = Integer.parseInt(st.nextToken());
        balls = new int[ballCount + 1];
        for (int i = 0; i < balls.length; i++) {
            balls[i] = i;
        }
    }

    private void changeBall(int index1, int index2) {
        int temp = balls[index1];
        balls[index1] = balls[index2];
        balls[index2] = temp;
    }

    private void printBall() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < balls.length; i++) {
            sb.append(balls[i]).append(" ");
        }
        System.out.println(sb);
    }
}
