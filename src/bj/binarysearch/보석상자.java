package bj.binarysearch;

import java.io.*;
import java.util.*;

public class 보석상자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] jewelries = new int[m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            jewelries[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, jewelries[i]);
        }

        int s = 1;
        int e = max;
        int result = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (check(jewelries, n, mid)) { // 가능하면, 큰 범위를 버림 (최솟값을 찾음)
                result = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        System.out.println(result);
    }

    private static boolean check(int[] jewelries, int n, int max) {
        int count = 0;
        for (int i = 0; i < jewelries.length; i++) {
            count += jewelries[i] / max;
            if (jewelries[i] % max != 0) {
                count++;
            }
        }
        return count <= n;
    }
}
