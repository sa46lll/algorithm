package bj.bruteforce;

import java.io.*;
import java.util.*;

public class 색종이 {

    private int n;
    private int[][] papers;
    private int minX = Integer.MAX_VALUE;
    private int minY = Integer.MAX_VALUE;
    private int maxX = 0;
    private int maxY = 0;
    private int count = 0;

    public static void main(String[] args) throws IOException {
        new 색종이().solution();
    }

    private void solution() throws IOException {
        init();
        scanDirectory();
        System.out.println(count);
    }

    private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        papers = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            papers[i][0] = Integer.parseInt(st.nextToken());
            papers[i][1] = Integer.parseInt(st.nextToken());
            minX = Math.min(minX, papers[i][0]);
            minY = Math.min(minY, papers[i][1]);
            maxX = Math.max(maxX, papers[i][0] + 10);
            maxY = Math.max(maxY, papers[i][1] + 10);
        }
    }

    private void scanDirectory() {
        for (int i = minX; i < maxX; i++) {
            for (int j = minY; j < maxY; j++) {
                if (!isInSquare(i, j)) {
                    continue;
                }
                count++;
            }
        }
    }

    private boolean isInSquare(int x, int y) {
        for (int[] i : papers) {
            if (x >= i[0] && x < i[0] + 10 && y >= i[1] && y < i[1] + 10) {
                return true;
            }
        }
        return false;
    }
}
