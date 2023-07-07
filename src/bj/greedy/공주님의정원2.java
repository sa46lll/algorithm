package bj.greedy;

import java.io.*;
import java.util.*;

public class 공주님의정원2 {

    static int START_DAY = 301;
    static int END_DAY = 1130;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Flower2[] flowers = new Flower2[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            flowers[i] = new Flower2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(flowers);

        int startIdx = 0;
        int startDay = START_DAY;
        int endDay = 0;
        int count = 0;

        while (startDay <= END_DAY) {
            boolean isFind = false;
            for (int i = startIdx; i < n; i++) {
                // 시작일이 이전 꽃의 종료일보다 늦은 경우
                if (flowers[i].startDay > startDay) {
                    break;
                }
                // 종료일이 더 긴 경우
                if (flowers[i].endDay > endDay) {
                    endDay = flowers[i].endDay;
                    startIdx = i + 1;
                    isFind = true;
                }
            }
            // 가능한 꽃들 중 가장 긴 종료일을 가진 꽃으로 정보를 갱신
            if (isFind) {
                startDay = endDay;
                count++;
                continue;
            }
            // 꽃이 하나도 피지 않는 날이 있는 경우
            break;
        }

        if (endDay <= END_DAY) {
            System.out.println(0);
            return;
        }
        System.out.println(count);
    }
}

class Flower2 implements Comparable<Flower2> {

    int startDay;
    int endDay;

    Flower2(int startMonth, int startDay, int endMonth, int endDay) {
        this.startDay = startMonth * 100 + startDay;
        this.endDay = endMonth * 100 + endDay;
    }

    @Override
    public int compareTo(Flower2 o) { // startDay 오름치순, endDay 내림차순
        if (startDay == o.startDay) {
            return o.endDay - endDay;
        }
        return startDay - o.startDay;
    }
}
