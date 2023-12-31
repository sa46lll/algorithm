package bj.backtracking;

import java.util.*;

public class N과M_8 {

    static int n;
    static int m;
    static int[] arr;
    static List<Integer> nList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        for (int i = 0; i < n; i++) {
            nList.add(sc.nextInt());
        }

        Collections.sort(nList);

        recur(0, 0);

        System.out.println(sb);
    }

    private static void recur(int cur, int start) {
        if (cur == m) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            int k = nList.get(i);
            arr[cur] = k;
            recur(cur + 1, i);
        }
    }
}
