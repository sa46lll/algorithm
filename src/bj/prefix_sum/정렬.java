package bj.prefix_sum;

import java.io.*;
import java.util.*;

public class 정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] v = new int[n + 2]; // 앞뒤 패딩

        StringTokenizer st = new StringTokenizer(br.readLine());
        v[0] = Integer.MIN_VALUE;
        v[v.length - 1] = Integer.MAX_VALUE;
        for (int i = 1; i < v.length - 1; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] prefix = new boolean[v.length];
        boolean[] suffix = new boolean[v.length];

        // 패딩 true 설정
        prefix[0] = true;
        suffix[suffix.length - 1] = true;
        
        for (int i = 1; i < v.length; i++) {
            if (v[i] < v[i - 1]) {
                break;
            }
            prefix[i] = true;
        }

        for (int i = v.length - 2; i > 0; i--) {
            if (v[i + 1] < v[i]) {
                break;
            }
            suffix[i] = true;
        }

        int count = 0;
        for (int i = 1; i < v.length - 1; i++) {
            if (prefix[i - 1] && suffix[i + 1] && v[i - 1] <= v[i+1]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
