package bj.binarysearch;

import java.io.*;
import java.util.*;

public class 이상한술집 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int friends = Integer.parseInt(st.nextToken());

        int[] capacity = new int[n];
        for (int i = 0; i < capacity.length; i++) {
            capacity[i] = Integer.parseInt(br.readLine());
        }

        long s = 1;
        long e = Integer.MAX_VALUE;
        long result = 0;
        while (s <= e) {
            long mid = (s + e) / 2;
            if (check(capacity, friends, mid)) { // 만족하면, 주전자 용량을 높임 (최댓값)
                result = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean check(int[] capacity, int friends, long max) {
        long count = 0;
        for (int i : capacity) {
            count += i / max;
        }
        return friends <= count;
    }
}
