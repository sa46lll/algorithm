package bj.bruteforce;

import java.io.*;

public class 숫자야구 {

    private int[][] baseballs;

    public static void main(String[] args) throws IOException {
        new 숫자야구().solution();
    }

    private void solution() throws IOException {
        getUserInput();
        int count = 0;
        for (int i = 111; i < 1000; i++) {
            if (!check(i)) {
                continue;
            }
            count++;
        }
        System.out.println(count);
    }

    private void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        baseballs = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            baseballs[i][0] = Integer.parseInt(input[0]);
            baseballs[i][1] = Integer.parseInt(input[1]);
            baseballs[i][2] = Integer.parseInt(input[2]);
        }
    }

    private boolean check(int n) {
        int[] mine = new int[]{n / 100, n / 10 % 10, n % 10};
        if (mine[0] == mine[1] || mine[1] == mine[2] || mine[0] == mine[2]) {
            return false;
        }
        for (int i : mine) {
            if (i == 0) {
                return false;
            }
        }
        for (int[] i : baseballs) {
            int[] yours = new int[]{i[0] / 100, i[0] / 10 % 10, i[0] % 10};
            int strike = getStrike(mine, yours);
            int ball = getBallCount(mine, yours);
            if (strike != i[1] || ball != i[2]) {
                return false;
            }
        }
        return true;
    }

    private int getStrike(int[] arr1, int[] arr2) {
        int strike = 0;
        if (arr1[0] == arr2[0]) {
            strike++;
        }
        if (arr1[1] == arr2[1]) {
            strike++;
        }
        if (arr1[2] == arr2[2]) {
            strike++;
        }
        return strike;
    }

    private int getBallCount(int[] arr1, int[] arr2) {
        int ball = 0;
        if (arr1[0] == arr2[1] || arr1[0] == arr2[2]) {
            ball++;
        }
        if (arr1[1] == arr2[0] || arr1[1] == arr2[2]) {
            ball++;
        }
        if (arr1[2] == arr2[0] || arr1[2] == arr2[1]) {
            ball++;
        }
        return ball;
    }
}
