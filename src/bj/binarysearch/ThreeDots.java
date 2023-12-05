package bj.binarysearch;

import java.io.*;
import java.util.*;

public class ThreeDots {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (testCount-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> v = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                v.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(v);

            int count = 0;
            for (int i = 0; i < v.size(); i++) {
                for (int j = i + 1; j < v.size(); j++) {
                    int lastNum = 2 * v.get(j) - v.get(i);
                    if (!findNum(v, lastNum)) {
                        continue;
                    }
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean findNum(List<Integer> v, int num) {
        int s = 0;
        int e = v.size() - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (v.get(mid) == num) {
                return true;
            } else if (v.get(mid) > num) { // 찾는게 작으면 오른쪽을 버림
                e = mid - 1;
            } else { // 찾는게 크면 왼쪽을 버림
                s = mid + 1;
            }
        }
        return false;
    }
}
