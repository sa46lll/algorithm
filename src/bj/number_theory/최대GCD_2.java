package bj.number_theory;

import java.io.*;

public class 최대GCD_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (testCount-- > 0) {
            String[] s = br.readLine().split(" ");
            int[] arr = new int[s.length];
            int max = 0;

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    max = Math.max(max, getGcd(arr[i], arr[j]));
                }
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

    private static int getGcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
