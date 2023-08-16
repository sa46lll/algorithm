package bj.string;

import java.util.*;

public class 쿠키의신체측정 {

    static String[] cookieMap;
    static int[] heart = new int[2]; // 심장의 위치
    static int[] bodySize = new int[5]; // 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리

    public static void main(String[] args) {
        promptFromUserInput();
        computeBodySize();
        displayBodySize();
    }

    private static void promptFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        cookieMap = new String[n];
        int mapIndex = 0;
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            cookieMap[mapIndex++] = s;
        }
    }

    private static void computeBodySize() {
        // 심장의 위치
        int headRow = 0;
        int headCol = 0;
        for (int i = 0; i < cookieMap.length; i++) {
            if (!cookieMap[i].contains("*")) {
                continue;
            }
            headRow = i;
            headCol = cookieMap[i].indexOf("*");
            break;
        }

        // 팔의 위치
        int leftArm = headCol - cookieMap[headRow + 1].indexOf("*");
        int rightArm = cookieMap[headRow + 1].lastIndexOf("*") - headCol;

        // 허리, 다리의 위치
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        for (int i = headRow + 2; i < cookieMap.length; i++) {
            int index = cookieMap[i].indexOf("*");
            int lastIndex = cookieMap[i].lastIndexOf("*");
            if (index == headCol) {
                waist++;
            }
            if (index == headCol - 1) {
                leftLeg++;
            }
            if (lastIndex == headCol + 1) {
                rightLeg++;
            }
        }
        heart = new int[]{headRow, headCol};
        bodySize = new int[]{leftArm, rightArm, waist, leftLeg, rightLeg};
    }

    private static void displayBodySize() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d %d", heart[0] + 2, heart[1] + 1)).append("\n");
        Arrays.stream(bodySize).forEach(i -> sb.append(i).append(" "));
        System.out.println(sb);
    }
}
