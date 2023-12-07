package bj.sort;

import java.io.*;
import java.util.*;

public class 좌표정렬하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] temp = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            points.add(temp);
        }

        // [i][1] 오름차순, [i][0] 오름차순
        Collections.sort(points, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] point : points) {
            sb.append(point[0]).append(" ").append(point[1]).append("\n");
        }
        System.out.println(sb);
    }
}
