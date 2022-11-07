package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PositiveNumber30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split("");
        Arrays.sort(nums);

        StringBuffer sb = new StringBuffer();
        for (int i = nums.length - 1; i >= 0; i--) {
            sb.append(nums[i]);
        }
        String s = sb.toString();
        if (s.charAt(s.length() - 1) != '0' || sumFromString(s) % 3 != 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(s);
    }

    private static int sumFromString(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (char c : chars) {
            result += Integer.parseInt(String.valueOf(c));
        }
        return result;
    }
}
