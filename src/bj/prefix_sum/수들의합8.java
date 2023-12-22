package bj.prefix_sum;

import java.io.*;
import java.util.*;

public class 수들의합8 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 1];
        long[] prefix = new long[n + 1]; // 최대 2 * 10^9
        long[] prefix2 = new long[n + 1];
        long[] prefix3 = new long[n + 1]; // 최대 4 * 10^9
        Map<Long, Integer> cntMap = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr1[i];
            prefix2[i] = prefix2[i - 1] + arr2[i];
            prefix3[i] = prefix[i] - prefix2[i];
        }

        long count = 0;
        for (int i = 0; i < prefix3.length; i++) {
            count += cntMap.getOrDefault(prefix3[i], 0);
            cntMap.put(prefix3[i], cntMap.getOrDefault(prefix3[i], 0) + 1);
        }
        System.out.println(count);
    }
}
