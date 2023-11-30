package bj.number_theory;

import java.io.*;
import java.util.*;

public class SleepingInClass { // 미완

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (testCount-- > 0) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = -1;
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }

            if (min == max) {
                sb.append(0).append("\n");
                continue;
            }

            int count = 0;
            int last = arr[0];
            int groupCount = 1;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == -1) {
                    continue;
                }
                if (arr[i] < max) {
                    arr[i + 1] += arr[i];
                    arr[i] = -1;
                    max = Math.max(max, arr[i + 1]);
                    last = arr[i + 1];
                    count++;
                    continue;
                }
                groupCount++;
                last = arr[i + 1];
            }
//            System.out.println("groupCount = " + groupCount);
            if (last == 0) {
                count++;
            } else if (last != max) {
                count += (groupCount - 1);
            }
//            System.out.println(last);
//            System.out.println(max);
            sb.append(count).append("\n");
//            System.out.println(Arrays.toString(arr));
        }
        System.out.println(sb);
    }
}
