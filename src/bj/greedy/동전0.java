package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int result = 0;
        int[] moneys = new int[n];
        for (int i = 0; i < moneys.length; i++) {
            moneys[i] = Integer.parseInt(br.readLine());
        }

        for (int i = n - 1; i >= 0; i--) {
            if (moneys[i] <= k) {
                result += k / moneys[i];
                k %= moneys[i];
            }
        }
        System.out.println(result);
    }
}
