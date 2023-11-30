package bj.number_theory;

import java.util.*;

public class 보석도둑 {

    public static void main(String[] args) {
        new 보석도둑().solution();
    }

    private void solution() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        List<Long> queue = new LinkedList<>();
        if (n == 1) {
            System.out.println(1);
            System.out.println(1);
            return;
        }
        for (long i = 2; i * i <= n; i++) { // 2 ~ 루트n : 소인수
            while (n % i == 0) {
                queue.add(i);
                n /= i;
            }
        }
        if (n != 1) { // 나머지가 1이 아닌 경우, 남은 수는 루트n 보다 큰 유일한 소인수
            queue.add(n);
        }
        printResult(queue);
    }

    private void printResult(List<Long> queue) {
        int size = queue.size();
        StringBuilder sb = new StringBuilder();
       for (long i : queue) {
           sb.append(i).append(" ");
       }
        System.out.println(size);
        System.out.println(sb);
    }
}
