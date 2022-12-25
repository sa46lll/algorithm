package bj.bfs;

import java.io.*;
import java.util.*;

public class 숨바꼭질 {

    static int n, k;
    static int[] visit = new int[100001];
    static int nextIndex;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visit[n] = 1;
        while (!queue.isEmpty()) {
            int q = queue.poll();
            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        nextIndex = q + 1;
                        break;
                    case 1:
                        nextIndex = q - 1;
                        break;
                    case 2:
                        nextIndex = q * 2;
                }
                if (nextIndex == k) {
                    result = visit[q];
                    return;
                }
                if (checkNextIndex(nextIndex)) {
                    queue.add(nextIndex);
                    visit[nextIndex] = visit[q] + 1;
                }
            }
        }
    }

    private static boolean checkNextIndex(int nextIndex) {
        return nextIndex >= 0 && nextIndex < visit.length && visit[nextIndex] == 0;
    }
}
