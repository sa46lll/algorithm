package bj.implementation;

import java.io.*;

public class 부녀회장이될테야 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (testCount-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int result = recursive(k, n);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int recursive(int k, int n) {
        if (k == 0 || n == 0) {
            return n;
        }
        return recursive(k, n - 1) + recursive(k - 1, n);
    }
}
