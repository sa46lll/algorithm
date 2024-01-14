package bj.number_theory;

import java.util.*;

public class 정수좌표의개수 {

    static int n;
    static int m;
    static int k;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n + 1][m + 1];
        int count = 0;

        for (int x1 = 0; x1 <= n; x1++) {
            for (int y1 = 0; y1 <= m; y1++) {
                for (int x2 = x1; x2 <= n; x2++) {
                    for (int y2 = y1; y2 <= m; y2++) {
                        if (x1 == x2 && y1 == y2) {
                            continue;
                        }
                        if ((x1 == x2 || y1 == y2) && Math.abs(x2 - x1) + Math.abs(y2 - y1) == k - 1) {
                                count++;
                                continue;
                        }
                        if (getGcd(Math.abs(x2 - x1), Math.abs(y2 - y1)) == k - 1) {
                            count+= 2;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static int getGcd(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
