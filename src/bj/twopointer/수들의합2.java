package bj.twopointer;

import java.util.*;

public class 수들의합2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        int sum = 0;
        int s = 0;
        int e = -1;
        while (e < n) {
            if (sum > m) { // 크면 간격을 좁힘
                sum -= arr[s];
                s++;
                continue;
            }
            if (sum < m) { // 작으면 간격을 넓힘
                e++;
                if (e == n) { // ?
                    break;
                }
                sum += arr[e];
                continue;
            }
            sum -= arr[s];
            s++;
            e++;
            count++;
            if (e == n) { // ?
                break;
            }
            sum += arr[e];
        }

        System.out.println(count);
    }
}
