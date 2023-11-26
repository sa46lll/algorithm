package bj.bruteforce;

import java.io.*;
import java.util.*;

public class 반복하지않는수 { // 미완

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();
        int max = 0;
        while (n != 0) {
            list.add(n);
            max = Math.max(max, n);
            n = Integer.parseInt(br.readLine());
        }

        int num = 1;
        int[] unRepeated = new int[max + 1];
        for (int idx = 1; idx <= 1_000_000; idx++) {
            if (idx == max + 1) {
                break;
            }
            if (isRepeatNumber(num)) {
                num++;
                idx--;
                continue;
            }
            unRepeated[idx] = num;
            num++;
        }
        for (int i : list) {
            sb.append(unRepeated[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isRepeatNumber(int n) {
        int[] nums = new int[10]; // 0 ~ 9
        while (n > 0) {
            int temp = n % 10;
            nums[temp] += 1;
            if (nums[temp] > 1) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}
