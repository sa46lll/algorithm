package bj.number_theory;

import java.util.*;

public class 보석도둑_2 {

    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static long weight;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        weight = sc.nextLong();
        StringBuilder sb = new StringBuilder();

        if (weight == 1) {
            System.out.println("1\n1");
            return;
        }

        long n = weight;
        for (long i = 2; i * i <= weight; i++) {
            while (n % i == 0) {
                pq.add(i);
                n /= i;
            }
        }

        if (n != 1) {
            pq.add(n);
        }

        sb.append(pq.size()).append("\n");

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }

        System.out.println(sb);
    }
}
