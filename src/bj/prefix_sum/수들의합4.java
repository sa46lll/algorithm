package bj.prefix_sum;

import java.io.*;
import java.util.*;

public class 수들의합4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] v = new int[n + 1];
        long[] prefix = new long[n + 1]; // 최대 2_000_000_000
        Map<Long, Integer> cnt = new TreeMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < v.length; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + v[i];
        }

        long result = 0;
        for (int i = 0; i < prefix.length; i++) {
            result += cnt.getOrDefault(prefix[i] - k, 0);
            cnt.put(prefix[i], cnt.getOrDefault(prefix[i], 0) + 1);
        }

        System.out.println(result);
    }
}
