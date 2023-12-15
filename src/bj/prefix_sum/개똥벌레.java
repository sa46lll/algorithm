package bj.prefix_sum;

import java.io.*;
import java.util.*;

public class 개똥벌레 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] v = new int[h + 1];

        for (int i = 0; i < n; i += 2) {
            v[1] += 1; // 1-시작
            v[Integer.parseInt(br.readLine()) + 1] += -1; // 1-마지막
            v[h - Integer.parseInt(br.readLine()) + 1] += 1; // 2-시작
        }

        for (int i = 1; i < v.length; i++) {
            v[i] += v[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 1; i < v.length; i++) {
            if (v[i] < min) {
                min = v[i];
                count = 1;
            } else if (v[i] == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}
