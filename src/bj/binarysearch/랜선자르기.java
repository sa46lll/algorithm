package bj.binarysearch;

import java.io.*;
import java.util.*;

public class 랜선자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lansons = new int[k];
        for (int i = 0; i < k; i++) {
            lansons[i] = Integer.parseInt(br.readLine());
        }

        long s = 1;
        long e = Integer.MAX_VALUE;
        long result = 1;
        while (s <= e) {
            long mid = (s + e) / 2;
            if (check(lansons, n, mid)) { // 랜선 개수를 만족하면, 랜선을 길이를 높인다 (최댓값)
                result = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean check(int[] lansons, int n, long max) {
        long count = 0;
        for (int i : lansons) {
            count += i / max;
        }
        return count >= n;
    }
}
