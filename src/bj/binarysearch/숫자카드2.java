package bj.binarysearch;

import java.io.*;
import java.util.*;

public class 숫자카드2 {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int testCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (testCount-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            int lastIndex = getLastIndex(num);
            if (lastIndex == -1) { // 더 좋은 방법이 있는지..?
                sb.append(0).append(" ");
            } else {
                sb.append(lastIndex - getFirstIndex(num) + 1).append(" ");
            }
        }
        System.out.println(sb);
    }

    static int getFirstIndex(int n) {
        int s = 0;
        int e = list.size() - 1;

        int idx = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (list.get(mid) == n) { // 1234444567 일 때, 같으면 오른쪽을 버림
                idx = mid;
                e = mid - 1;
            } else if (list.get(mid) > n) { // 찾는게 더 작으니, 오른쪽을 버림
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return idx;
    }

    static int getLastIndex(int n) {
        int s = 0;
        int e = list.size() - 1;

        int idx = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (list.get(mid) == n) { // 1234444567 일 때, 같으면 왼쪽을 버림
                idx = mid;
                s = mid + 1;
            } else if (list.get(mid) > n) { // 찾는게 더 작으니, 오른쪽을 버림
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return idx;
    }
}
