package bj.number_theory;

import java.util.*;

public class 보이는점의개수_2 {

    static int[][] arr = new int[1010][1010];
    static boolean[][] visited = new boolean[1010][1010];
    static Set<Float> slopeSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        init();

        while (testCount-- > 0) {
            int x = sc.nextInt();
            int count = 0;

            for (int i = 1; i < x; i++) {
                for (int j = i + 1; j <= x; j++) {
                    if (!visited[i][j]) {
                        continue;
                    }
                    count++;
                }
            }
            sb.append(count * 2 + 3).append("\n");
        }

        System.out.println(sb);
    }

    private static void init() {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                float slope = (float) j / i;
                if (!slopeSet.contains(slope)) {
                    visited[i][j] = true;
                    slopeSet.add(slope);
                }
            }
        }
    }
}
