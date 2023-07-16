package bj.twopointer;

import java.util.*;

public class 합이0 {

    static void solution(int[] skills) {
        Arrays.sort(skills);

        long result = 0;
        for (int i = 0; i < skills.length - 1; i++) {
            int now = skills[i];
            int left = i + 1;
            int right = skills.length - 1;

            while (left < right) {
                int sum = skills[left] + skills[right] + now;
                if (sum == 0) {
                    int leftCount = 1;
                    int rightCount = 1;
                    // 양쪽 같은 수가 몇개인지 갯수를 카운트
                    if (skills[left] == skills[right]) {
                        int repeatCount = right - left + 1;
                        result += combination(repeatCount);
                        break;
                    }
                    while (left + 1 < right && skills[left] == skills[left + 1]) {
                        left++;
                        leftCount++;
                    }
                    while (right - 1 > left && skills[right] == skills[right - 1]) {
                        right--;
                        rightCount++;
                    }
                    result += (long) leftCount * rightCount;
                }
                if (sum > 0) {
                    right--;
                    continue;
                }
                left++;
            }
        }
        System.out.println(result);
    }

    private static int combination(int n) {
        return n * (n - 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] skills = new int[n];
        for (int i = 0; i < n; i++) {
            skills[i] = scanner.nextInt();
        }
        solution(skills);
    }
}
