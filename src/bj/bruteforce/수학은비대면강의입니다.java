package bj.bruteforce;

import java.io.*;
import java.util.*;

public class 수학은비대면강의입니다 {

    private int[] nums;

    public static void main(String[] args) throws IOException {
        new 수학은비대면강의입니다().solution();
    }

    private void solution() throws IOException {
        getUserInput();
        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if (nums[0] * i + nums[1] * j == nums[2] && nums[3] * i + nums[4] * j == nums[5]) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }

    private void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[6];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
