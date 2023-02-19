package bj.bfs;

import java.io.*;
import java.util.*;

public class 스타트링크 {

    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static int[] count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = -Integer.parseInt(st.nextToken());
        count = new int[F + 1];
        visited = new boolean[F + 1];
        if (S == G) {
            System.out.println(0);
            return;
        }
        bfs();
        if (visited[G]) {
            System.out.println(count[G]);
            return;
        }
        System.out.println("use the stairs");
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        count[S] = 0;
        visited[S] = true;
        while (!queue.isEmpty()) {
            Integer floor = queue.poll();
            int nextFloor = floor + U;
            int nextFloor2 = floor + D;
            if (checkValidation(nextFloor) && !visited[nextFloor]) {
                queue.offer(nextFloor);
                visited[nextFloor] = true;
                count[nextFloor] = count[floor] + 1;
                if (nextFloor == G) {
                    return;
                }
            }
            if (checkValidation(nextFloor2) && !visited[nextFloor2]) {
                queue.offer(nextFloor2);
                visited[nextFloor2] = true;
                count[nextFloor2] = count[floor] + 1;
                if (nextFloor2 == G) {
                    return;
                }
            }
        }
    }

    private static boolean checkValidation(Integer floor) {
        return floor >= 1 && floor <= F;
    }
}
