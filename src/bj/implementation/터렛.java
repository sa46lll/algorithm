package bj.implementation;

import java.io.*;
import java.util.*;

public class 터렛 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] num = new int[6];
        while (testCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < num.length; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(calculate(num)).append("\n");
        }
        System.out.println(sb);
    }

    private static int calculate(int[] nums) {
        int longestSide = getDistance(nums[0], nums[1], nums[3], nums[4]);
        int sumOfTwoSide = (nums[2] + nums[5]) * (nums[2] + nums[5]);
        int differenceOfTwoSide = (nums[2] - nums[5]) * (nums[2] - nums[5]);

        if (nums[0] == nums[3] && nums[1] == nums[4] && nums[2] == nums[5]) { // 동일한 원일 때
            return -1;
        }
        if (nums[0] == nums[3] && nums[1] == nums[4]) { // 중심은 같고, 반지름은 다를 때
            return 0;
        }
        if (longestSide > sumOfTwoSide) {
             return 0;
        }
        if (longestSide == sumOfTwoSide) {
            return 1;
        }
        if (longestSide < differenceOfTwoSide) {
            return 0;
        }
        if (longestSide == differenceOfTwoSide) {
            return 1;
        }
        return 2;
    }

    private static int getDistance(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}
