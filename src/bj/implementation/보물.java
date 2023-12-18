package bj.implementation;

import java.io.*;
import java.util.*;

public class 보물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v1.add(Integer.parseInt(st1.nextToken()));
            v2.add(Integer.parseInt(st2.nextToken()));
        }

        Collections.sort(v1);
        Collections.sort(v2);

        int result = 0;
        for (int i = 0; i < v1.size(); i++) {
            result += v1.get(i) * v2.get(v1.size() - 1 - i);
        }

        System.out.println(result);
    }
}
