package bj.prefix_sum;

import java.io.*;
import java.util.*;

public class 구간합구하기4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] v = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < v.length; i++) {
            v[i] = v[i - 1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(v[e] - v[s - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
