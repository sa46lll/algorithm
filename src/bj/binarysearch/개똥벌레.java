package bj.binarysearch;

import java.io.*;
import java.util.Arrays;

public class 개똥벌레 {

    static int[] topObstacle;
    static int[] bottomObstacle;
    static int n;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[1]);
        topObstacle = new int[n / 2];
        bottomObstacle = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            bottomObstacle[i] = Integer.parseInt(br.readLine());
            topObstacle[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bottomObstacle);
        Arrays.sort(topObstacle);

        int min = n;
        int count = 0;
        for (int floor = 1; floor < h + 1; floor++) {
            int obstacles = obstacleCount(floor, bottomObstacle) + obstacleCount(h - floor + 1, topObstacle);
            if (obstacles == min) {
                count++;
                continue;
            }
            if (obstacles < min) {
                min = obstacles;
                count = 1;
            }
        }
        System.out.println(min + " " + count);
    }

    // 이분 탐색
    private static int obstacleCount(int floor, int[] arr) {
        int left = 0;
        int right = n / 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= floor) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return arr.length - right;
    }
}
