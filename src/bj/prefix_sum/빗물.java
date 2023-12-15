package bj.prefix_sum;

import java.io.*;
import java.util.*;

public class 빗물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] v = new int[w + 2];
        st = new StringTokenizer(br.readLine());

        int blocks = 0;
        for (int i = 1; i < v.length - 1; i++) {
            v[i] = Integer.parseInt(st.nextToken());
            blocks += v[i];
        }

        int[] prefixSum = new int[v.length];
        int[] suffixSum = new int[v.length];

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1], v[i]);
        }

        for (int i = suffixSum.length - 2; i > 0; i--) {
            suffixSum[i] = Math.max(suffixSum[i + 1], v[i]);
        }

        int rainyBlocks = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            rainyBlocks += Math.min(prefixSum[i], suffixSum[i]);
        }

        System.out.println(rainyBlocks - blocks);
    }
}
