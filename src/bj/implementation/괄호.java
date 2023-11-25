package bj.implementation;

import java.io.*;

public class 괄호 {

    public static void main(String[] args) throws IOException {
        new 괄호().solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            char[] chars = br.readLine().toCharArray();
            if (!check(chars)) {
                sb.append("NO\n");
                continue;
            }
            sb.append("YES\n");
        }
        System.out.println(sb);
    }

    private static boolean check(char[] chars) {
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            sum += chars[i] == '(' ? 1 : -1;
            if (sum < 0) {
                return false;
            }
        }
        return sum == 0;
    }
}
