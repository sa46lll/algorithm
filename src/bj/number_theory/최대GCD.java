package bj.number_theory;

import java.io.*;

public class 최대GCD {

    public static void main(String[] args) throws IOException {
        new 최대GCD().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (testCount-- > 0) {
            String[] s = br.readLine().split(" ");
            int[] nums = mapToInt(s);
            int gcd = getGcd(nums);
            sb.append(gcd).append("\n");
        }
        System.out.println(sb);
    }

    private int[] mapToInt(String[] s) {
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        return nums;
    }

    private int getGcd(int[] nums) {
        int gcd = 1;
        for (int i = 2; i <= Integer.MAX_VALUE; i++) {
            int count = 0;
            boolean maxFlag = true;
            for (int n : nums) {
                if (n >= i) {
                    maxFlag = false;
                }
                if (n % i == 0) {
                    count++;
                }
                if (count >= 2) {
                    gcd = Math.max(gcd, i);
                    break;
                }
            }
            if (maxFlag) { // 배열의 max보다 초과하면 멈춤
                break;
            }
        }
        return gcd;
    }
}
