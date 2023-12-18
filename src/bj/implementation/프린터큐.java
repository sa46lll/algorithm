package bj.implementation;

import java.io.*;
import java.util.*;

public class 프린터큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (testCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> idxQueue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int d = Integer.parseInt(st.nextToken());
                queue.add(d);
                pq.add(d);
                idxQueue.add(i);
            }

            int count = 0;
            while (!pq.isEmpty()) {
                count++;
                int max = pq.poll();
                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    int nowIdx = idxQueue.poll();
                    if (now != max) { // 스택을 다시 채우기
                        queue.add(now);
                        idxQueue.add(nowIdx);
                        continue;
                    }
                    if (nowIdx != m) {
                        break;
                    }
                    sb.append(count).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
