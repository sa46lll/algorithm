package bj.bruteforce;

import java.io.*;
import java.util.*;

public class 창고다각형 {

    private int maxHeight = 0;
    private int maxIndex = 0; // 최대 중 마지막 index

    public static void main(String[] args) throws IOException {
        new 창고다각형().solution();
    }

    private int[] heights;

    private void solution() throws IOException {
        getUserInput();

        int currentHeight = 0;
        int area = 0;
        // max 기준 왼쪽
        for (int idx = 1; idx < maxIndex; idx++) {
            if (heights[idx] <= currentHeight) {
                area += currentHeight;
                continue;
            }
            if (currentHeight == maxHeight - 1) {
                area += currentHeight * (maxIndex - idx);
                break;
            }
            currentHeight = heights[idx];
            area += currentHeight;
        }

        int currentHeight2 = 0;
        int area2 = 0;
        // max 기준 오른쪽
        for (int idx = 1000; idx >= maxIndex; idx--) { // 8 ~ 1000
            if (heights[idx] <= currentHeight2) {
                area2 += currentHeight2;
                continue;
            }
            if (currentHeight2 == maxHeight + 1) {
                area2 += currentHeight2 * (idx - maxIndex);
                break;
            }
            currentHeight2 = heights[idx];
            area2 += currentHeight2;
        }
        System.out.println(area + area2);
    }

    private void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        heights = new int[1001];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            heights[index] = height;

            if (heights[index] >= maxHeight) {
                maxHeight = heights[index];
                maxIndex = index;
            }
        }
    }
}
