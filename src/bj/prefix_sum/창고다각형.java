package bj.prefix_sum;

import java.io.*;
import java.util.*;

public class 창고다각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] v = new int[1002];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        int[] prefixSum = new int[v.length];
        int[] suffixSum = new int[v.length];

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1], v[i]);
        }

        for (int i = suffixSum.length - 2; i > 0; i--) {
            suffixSum[i] = Math.max(suffixSum[i + 1], v[i]);
        }

        int result = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            result += Math.min(prefixSum[i], suffixSum[i]);
        }
        System.out.println(result);
    }
}
