package bj.backtracking;

import java.util.*;

public class N과M_5 {

    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> nList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        visited = new boolean[10010];

        for (int i = 0; i < n; i++) {
            nList.add(sc.nextInt());
        }

        Collections.sort(nList);

        recur(0);
        System.out.println(sb);
    }

    private static void recur(int cur) {
        if (cur == m) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            int k = nList.get(i);
            if (visited[k]) {
                continue;
            }
            visited[k] = true;
            arr[cur] = k;
            recur(cur + 1);
            visited[k] = false;
        }
    }
}
