package bj.binarysearch;

import java.io.*;
import java.util.*;

public class 숫자카드 {

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
            int add = isPresent(num) ? 1 : 0;
            sb.append(add).append(" ");
        }
        System.out.println(sb);
    }
    
    static boolean isPresent(int n) {
        int s = 0;
        int e = list.size() - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (list.get(mid) == n) {
                return true;
            }
            if (list.get(mid) < n) { // 찾는게 더 크면 왼쪽을 버림
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return false;
    }
}
