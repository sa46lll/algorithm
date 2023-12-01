package bj.number_theory;

import java.io.*;
import java.util.*;

/*
- 유클리드 호제법
- gcd(120, 112) == gcd(112, 8) == gcd(104, 8) == gcd(96, 8)
- gcd(a + 3d, a + 4d) == gcd(a + 3d, d) == gcd(a, d)
 */
public class 등차수열과쿼리 {

    private int a;
    private int d;
    private int testCount;

    public static void main(String[] args) throws IOException {
        new 등차수열과쿼리().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        getUserInput(br);
        StringBuilder sb = new StringBuilder();

        while (testCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            long l = Integer.parseInt(st.nextToken());
            long r = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1: {
                    long result = a * (r - l + 1) + getSumAToB(l - 1, r - 1) * d;
                    sb.append(result).append("\n");
                    break;
                }
                case 2: {
                    if (l == r) {
                        sb.append(a + (l - 1) * d).append("\n");
                        break;
                    }
                    int gcd = getGcd(a, d);
                    sb.append(gcd).append("\n");
                    break;
                }
                default:
                    throw new IllegalArgumentException();
            }
        }
        System.out.println(sb);
    }

    private void getUserInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        testCount = Integer.parseInt(br.readLine());
    }

    private long getSumAToB(long x, long y) {
        return y * (y + 1) / 2 - (x - 1) * x / 2;
    }

    private int getGcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}
