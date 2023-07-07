package bj.greedy;

import java.io.*;
import java.util.*;

public class 선긋기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Line[] lines = new Line[n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            lines[i] = new Line(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        Arrays.sort(lines);

        int start = lines[0].start;
        int end = lines[0].end;
        int distance = lines[0].end - lines[0].start;
        for (int i = 1; i < n; i++) {
            if (lines[i].start >= start && lines[i].end <= end) { // 모두 안에 속해있을 경우
                start = lines[i].start;
                continue;
            }
            if (lines[i].start < end && lines[i].end > end) { // 겹쳐있을 경우
                distance += lines[i].end - end;
                start = lines[i].start;
                end = lines[i].end;
                continue;
            }
            // 겹쳐있지 않을 경우
            distance += lines[i].end - lines[i].start;
            start = lines[i].start;
            end = lines[i].end;
        }
        System.out.println(distance);
    }
}

class Line implements Comparable<Line> {

    int start;
    int end;

    Line(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Line o) { // start 오름차순, end 오름차순
        if (start == o.start) {
            return end - o.end;
        }
        return start - o.start;
    }
}
