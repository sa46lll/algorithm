package bj.number_theory;

import java.io.*;
import java.util.*;

public class SleepingInClass {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (testCount-- > 0) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            int sum = 0;
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
                sum += arr[i];
            }

            boolean isFlag = false;
            if (sum == 0) {
                sb.append(0).append("\n");
                continue;
            }
            for (int i = max; i <= sum; i++) {
                if (sum % i != 0) {
                    continue;
                }
                int groupSum = i;
                int count = 0;
                for (int j = 0; j < arr.length; j++) {
                    groupSum -= arr[j];
                    if (groupSum > 0) {
                        count++;
                        continue;
                    }
                    if (groupSum < 0) { // 다음 약수로 넘어감
                        break;
                    }
                    groupSum = i;
                    if (j == arr.length - 1) { // 마지막 요소에서 sum을 만족했을 때
                        isFlag = true;
                        sb.append(count).append("\n");
                        break;
                    }
                }
                if (isFlag) {
                    break;
                }
                if (i == arr.length - 1) {
                    sb.append(arr.length - 1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
