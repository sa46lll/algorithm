package bj.number_theory;

import java.io.*;
import java.util.*;

public class 등차수열과쿼리_2 {

    static int a;
    static int d;
    static long[] arr;
    static long[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());

        init();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            switch (command) {
                case (1): {
                    sb.append(getSum(l, r)).append("\n");
                    break;
                }
                case (2): {
                    if (l == r) {
                        sb.append(arr[l]).append("\n");
                        break;
                    }
                    sb.append(getGcd(a, d)).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    private static void init() {
        arr = new long[1000010];
        prefixSum = new long[1000010];
        arr[1] = a;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + d;
        }

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
    }

    private static long getSum(int l, int r) {
        return prefixSum[r] - prefixSum[l - 1];
    }

    private static long getGcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
