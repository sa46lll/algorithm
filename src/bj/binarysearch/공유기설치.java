package bj.binarysearch;

import java.io.*;
import java.util.*;

public class 공유기설치 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(v);

        long s = 0;
        long e = 1_000_000_000;
        long result = 0;
        while (s <= e) {
            long mid = (s + e) / 2;
            if (check(v, c, mid)) { // 만족하면, 공유기 사이의 거리를 늘린다 (최대 거리)
                result = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean check(int[] v, int c, long max) {
        long count = c - 1;
        int lastPoint = v[0];
        for (int i : v) {
            if (i - lastPoint >= max) {
                count--;
                lastPoint = i;
            }
            if (count <= 0) {
                break;
            }
        }
        return count <= 0;
    }
}
