package bj.recursion;

import java.io.*;
import java.util.*;

public class 곱셈 {

    static int a;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        recursiveMultiply(b, 1);
        System.out.println(result % c);
    }

    private static void recursiveMultiply(int b, long answer) {
        if (b == 1) {
            result = answer;
            return;
        }
        recursiveMultiply(--b, answer * a);
    }
}
