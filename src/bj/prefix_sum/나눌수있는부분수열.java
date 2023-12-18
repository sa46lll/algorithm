package bj.prefix_sum;

import java.io.*;
import java.util.*;

public class 나눌수있는부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (testCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[] prefix = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < prefix.length; i++) {
                prefix[i] = (Integer.parseInt(st.nextToken()) + prefix[i - 1]) % d;
            }

            int[] rest = new int[d];
            for (int p : prefix) {
                rest[p]++;
            }

            long result = 0;
            for (int r : rest) {
                result += (long) r * (r - 1) / 2;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
