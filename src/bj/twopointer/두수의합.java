package bj.twopointer;

import java.io.*;
import java.util.*;

public class 두수의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        int s = 0;
        int e = arr.size() - 1;
        while (s < e) {
            if (arr.get(s) + arr.get(e) > x) {
                e--;
                continue;
            }
            if (arr.get(s) + arr.get(e) < x) {
                s++;
                continue;
            }
            s++;
            e--;
            count++;
        }

        System.out.println(count);
    }
}
