package bj.bruteforce;

import java.io.*;
import java.util.*;

public class 일곱난쟁이 {

    private int[] heights = new int[9];
    private int sum = 0;

    public static void main(String[] args) throws IOException {
        new 일곱난쟁이().solution();
    }

    private void solution() throws IOException {
        initializeFromUserInput();
        Arrays.sort(heights);
        while (true) {
            for (int i =0; i < heights.length; i++) {
                for (int j = 0; j < heights.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    int numOfSeven = sum - heights[i] - heights[j];
                    if (numOfSeven == 100) {
                        printResultExceptTwoIndex(i, j);
                        return;
                    }
                }
            }
        }
    }

    private void initializeFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum+= heights[i];
        }
    }

    private void printResultExceptTwoIndex(int idx1, int idx2) {
        for (int i = 0; i < heights.length; i++) {
            if (i == idx1 || i == idx2) {
                continue;
            }
            System.out.println(heights[i]);
        }
    }
}
