package bj.binarysearch;

import java.io.*;
import java.util.*;

public class 작은벌점 {

    private static int[] aCard;
    private static int[] bCard;
    private static int[] cCard;

    public static void main(String[] args) throws IOException {
        getUserInput();
        Arrays.sort(cCard);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < aCard.length; i++) {
            for (int j = 0; j < bCard.length; j++) {
                int minScore = getMinScore(aCard[i], bCard[j]);
                System.out.println("minScore = " + minScore);
                min = Math.min(min, minScore);
            }
        }
        System.out.println(min);
    }

    private static int getMinScore(int a, int b) {
        int temp = Math.max(a, b);
        a = Math.min(a, b);
        b = temp;
        System.out.println("====" + a + " " + b);

        // a, b 사이값 찾기
        int s = 0;
        int e = cCard.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (cCard[mid] >= a && cCard[mid] <= b) {
                return b - a;
            } else if (cCard[mid] < a) { // 찾는게 크면, 왼쪽을 버림
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        // a보다 작은 값 중에 가장 큰 값 찾기
        s = 0;
        e = cCard.length - 1;
        int left = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (cCard[mid] <= a) { // 찾는게 크면, 왼쪽을 버림
                s = mid + 1;
                left = mid;
            } else {
                e = mid - 1;
            }
        }
        System.out.println("left = " + left);

        // b보다 큰 값 중에 가장 작은 값 찾기
        s = 0;
        e = cCard.length - 1;
        int right = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (cCard[mid] >= b) { // 만족하면, 최솟값을 찾음, 오른쪽을 버림
                e = mid - 1;
                right = mid;
            } else {
                s = mid + 1;
            }
        }
        System.out.println("right = " + right);

        if (left == -1) { // 만약 모든 값이 b보다 크면, right - a
            return cCard[right] - a;
        }
        if (right == -1) { // 만약 모든 값이 a보다 작으면, b - left
            return b - cCard[left];
        }
        return Math.min(Math.max(a, b) - cCard[left], cCard[right] - Math.min(a, b));
    }

    private static void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cardCount = new int[]{
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        };

        for (int i = 0; i < cardCount.length; i++) {
            st = new StringTokenizer(br.readLine());
            switch (i) {
                case 0: {
                    aCard = new int[cardCount[0]];
                    for (int j = 0; j < aCard.length; j++) {
                        aCard[j] = Integer.parseInt(st.nextToken());
                    }
                    break;
                }
                case 1: {
                    bCard = new int[cardCount[1]];
                    for (int j = 0; j < bCard.length; j++) {
                        bCard[j] = Integer.parseInt(st.nextToken());
                    }
                    break;
                }
                case 2: {
                    cCard = new int[cardCount[2]];
                    for (int j = 0; j < cCard.length; j++) {
                        cCard[j] = Integer.parseInt(st.nextToken());
                    }
                    break;
                }
            }
        }
    }
}
