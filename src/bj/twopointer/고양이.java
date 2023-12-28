package bj.twopointer;

import java.util.Scanner;

public class 고양이 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = (sc.next() + "#").toCharArray();
        int max = 0;

        int[] alp = new int[200];
        int s = 0;
        int e = -1;
        int typeCount = 0;
        while (e < arr.length - 1) {
            if (typeCount > n) { // 종류 개수가 많으면 앞을 줄임
                alp[arr[s]]--;
                if (alp[arr[s]] == 0) {
                    typeCount--;
                }
                s++;
                continue;
            }
            // 종류 개수가 적으면 뒤를 늘림
            max = Math.max(max, e - s + 1);
            e++;
            if (alp[arr[e]] == 0) {
                typeCount++;
            }
            alp[arr[e]]++;
        }

        System.out.println(max);
    }
}
