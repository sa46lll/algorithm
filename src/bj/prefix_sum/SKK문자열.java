package bj.prefix_sum;

import java.util.*;

public class SKK문자열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int[] prefixSum = new int[str.length() + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            char c = str.charAt(i - 1);
            prefixSum[i] = prefixSum[i - 1];
            if (c == 'S') {
                prefixSum[i] += 2;
            } else if (c == 'K') {
                prefixSum[i]--;
            }
        }

        int[] sCount = new int[str.length() + 1];

        for (int i = 1; i < str.length() + 1; i++) {
            sCount[i] = sCount[i - 1];
            if (str.charAt(i - 1) == 'S') {
                sCount[i]++;
            }
        }

        int[] idx = new int[500010];

        // 초기화
        for (int i = 0; i < idx.length; i++) {
            idx[i] = -1;
        }

        int max = -1;
        for (int i = 0; i < sCount.length; i++) {
            int startIdx = prefixSum[i] + 200000;
            if (idx[startIdx] == -1) { // 맨 처음 값일 때, 시작값 저장
                idx[startIdx] = i;
                continue;
            }

            if (sCount[i] == sCount[idx[startIdx]]) { // 중간에 'S'가 없을 때
                continue;
            }

            max = Math.max(max, i - idx[startIdx]);
        }
        System.out.println(max);
    }
}
