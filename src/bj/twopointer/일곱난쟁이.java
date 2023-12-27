package bj.twopointer;

import java.io.*;
import java.util.*;

public class 일곱난쟁이 {

    static List<Integer> heights = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;

        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            total += height;
            heights.add(height);
        }

        Collections.sort(heights);

        int s = 0;
        int e = heights.size() - 1;
        while (s < e) {
            int sum = heights.get(s) + heights.get(e);
            if (sum > total - 100) {
                e--;
                continue;
            }
            if (sum < total - 100) {
                s++;
                continue;
            }
            heights.set(s, -1);
            heights.set(e, -1);
            break;
        }

        for (int i : heights) {
            if (i == -1) {
                continue;
            }
            System.out.println(i);
        }
    }
}
