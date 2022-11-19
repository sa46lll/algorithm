package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 등수매기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] expectedRank = new int[n];
        for (int i = 0; i < n; i++) {
            expectedRank[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(expectedRank);
        long sum = 0;
        for (int i = 0; i < expectedRank.length; i++) {
            sum += Math.abs(expectedRank[i] - i - 1);
        }
        System.out.println(sum);
    }
}
