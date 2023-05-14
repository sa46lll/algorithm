package bj.bfs;

import java.io.*;
import java.util.*;

public class 숨바꼭질2 {

    static int n;
    static int k;
    static int[] visited = new int[100_001];
    static int time;

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
        System.out.println(time);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int i = 0; i < 3; i++) {
                int nextIndex;
                switch (i) {
                    case 0 :
                        nextIndex = index - 1;
                        break;
                    case 1 :
                        nextIndex = index + 1;
                        break;
                    default :
                        nextIndex = index * 2;
                }
                if (checkValidation(nextIndex) && visited[nextIndex] == 0) {
                    visited[nextIndex] = visited[index] + 1;
                    queue.add(nextIndex);
                }
                if (nextIndex == k) {
                    time = visited[nextIndex];
                    return;
                }
            }
        }
    }

    private static boolean checkValidation(int x) {
        return x >= 0 && x < visited.length && x != n;
    }
}
