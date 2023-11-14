package bj.implementation;

import java.io.*;
import java.util.*;

public class 배수와약수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if (n1 == 0 && n2 == 0) {
                break;
            }
            if (n1 % n2 == 0) {
                sb.append("multiple\n");
                continue;
            }
            if (n2 % n1 == 0) {
                sb.append("factor\n");
                continue;
            }
            sb.append("neither\n");
        }
        System.out.println(sb);
    }
}
