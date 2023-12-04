package bj.sort;

import java.util.*;

public class 소트인사이드 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }

        Collections.sort(list);
        printResult(list);
    }

    private static void printResult(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(list.size() - i - 1));
        }
        System.out.println(sb);
    }
}
