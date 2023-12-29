package bj.implementation;

import java.io.*;
import java.util.*;

public class 듣보잡 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        Set<String> result = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (set.contains(s)) {
                result.add(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String i : result) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
