package bj.implementation;

import java.io.*;
import java.util.*;

public class 블랙잭 {

    private int n;
    private int m;
    private int[] cards;
    private int max;

    public static void main(String[] args) throws IOException {
        new 블랙잭().solution();
    }

    private void solution() throws IOException {
        initializeFromUserInput();
        Arrays.sort(cards);
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < cards.length; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum > m) {
                        continue;
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        System.out.println(max);
    }

    private void initializeFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
    }
}
