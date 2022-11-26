package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Lesson[] lessons = new Lesson[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            lessons[i] = new Lesson(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        Arrays.sort(lessons, (o1, o2) -> { // end, start 순으로 오름차순
            if (o1.end == o2.end) {
                return Integer.compare(o1.start, o2.start);
            }
            return Integer.compare(o1.end, o2.end);
        });

        int result = 0;
        int lastEndTime = 0;
        for (Lesson l : lessons) {
            if (l.start >= lastEndTime) {
                lastEndTime = l.end;
                result++;
            }
        }
        System.out.println(result);
    }
}

class Lesson {
    int start;
    int end;

    public Lesson(int start, int end) {
        this.start = start;
        this.end = end;
    }
}