package bj.greedy;

import java.io.*;
import java.util.*;

public class 강의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].end);

        for (int i = 1; i < n; i++) {
            int end = pq.peek();
            if (lectures[i].start >= end) {
                pq.poll();
            }
            pq.add(lectures[i].end);
        }
        System.out.println(pq.size());
    }
}

class Lecture implements Comparable<Lecture> {

    int start;
    int end;

    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Lecture o) { // start 오름치순, end 오름차순
        if (o.start == start) {
            return end - o.end;
        }
        return start - o.start;
    }
}
