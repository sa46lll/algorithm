package bj.twopointer;

import java.util.*;

public class 같이눈사람만들래 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            heights.add(sc.nextInt());
        }

        Collections.sort(heights);

        int difference = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum1 = heights.get(i) + heights.get(j);
                int s = 0;
                int e = n - 1;
                while (s < e) {
                    // i. j일 경우 증가/감소
                    if (s == i || s == j) {
                        s++;
                        continue;
                    }
                    if (e == j || e == i) {
                        e--;
                        continue;
                    }

                    difference = Math.min(difference, Math.abs(heights.get(s) + heights.get(e) - sum1));

                    if (heights.get(s) + heights.get(e) > sum1) { // 값이 크면 오른쪽을 작게함
                        e--;
                        continue;
                    }
                    if (heights.get(s) + heights.get(e) < sum1) { // 값이 작으면 왼쪽을 키움
                        s++;
                        continue;
                    }
                    difference = 0;
                    break;
                }
            }
        }
        System.out.println(difference);
    }
}
