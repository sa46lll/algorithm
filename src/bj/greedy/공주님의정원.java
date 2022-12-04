package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공주님의정원 {
    static final int END_DATE = 1130;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        Flower[] flowers = new Flower[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            Flower flower = new Flower(calculateDate(Integer.parseInt(s[0]), Integer.parseInt(s[1])),
                    calculateDate(Integer.parseInt(s[2]), Integer.parseInt(s[3])));
            flowers[i] = flower;
        }
        Arrays.sort(flowers);

        int startDay = 301;
        int startIdx = 0;
        int curEndDay = 0;
        boolean isFind;
        while (startDay <= END_DATE) {
            isFind = false;
            for (int i = startIdx; i < flowers.length; i++) {
                if (flowers[i].start > startDay) {
                    break;
                }
                if (flowers[i].end > curEndDay) {
                    curEndDay = flowers[i].end;
                    startIdx  = i + 1;
                    isFind = true;
                }
            }
            if (isFind) {
                startDay = curEndDay;
                result++;
                continue;
            }
            break;
        }
        if (curEndDay > END_DATE) {
            System.out.println(result);

            return;
        }
        System.out.println(0);
    }

    private static int calculateDate(int month, int day) {
        return month * 100 + day;
    }
}

class Flower implements Comparable<Flower> {
    int start;
    int end;

    Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Flower o) { // start 오름차순, end 내림차순
        if (start == o.start) {
            return o.end - end;
        }
        return start - o.start;
    }
}