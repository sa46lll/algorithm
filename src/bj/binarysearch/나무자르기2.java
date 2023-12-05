package bj.binarysearch;

import java.io.*;
import java.util.*;

public class 나무자르기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] trees = new long[n];
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            max = Math.max(trees[i], max);
        }

        long s = 0;
        long e = max;
        long result = 0;
        while (s <= e) {
            long mid = (s + e) / 2;
            if (getSum(trees, mid) == m) {
                result = mid;
                break;
            } else if (getSum(trees, mid) > m) { // 잘린게 더 많으면, 길이를 높여야 함.
                result = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static long getSum(long[] trees, long n) {
        long sum = 0;
        for (long tree : trees) {
            sum += Math.max(tree - n, 0);
        }
        return sum;
    }
}
