package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] availableWeights = new int[n];
        for (int i = 0; i < n; i++) {
            availableWeights[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(availableWeights);

        int result = 0;
        for (int i = availableWeights.length - 1; i >= 0; i--) {
            int nowMaxWeight = availableWeights[i] * (availableWeights.length - i);
            if (nowMaxWeight > result) {
                result = nowMaxWeight;
            }
        }
        System.out.println(result);
    }
}
