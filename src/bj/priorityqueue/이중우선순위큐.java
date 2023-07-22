package bj.priorityqueue;

import java.io.*;
import java.util.*;

public class 이중우선순위큐 {

    static PriorityQueue<Integer> minPq;
    static PriorityQueue<Integer> maxPq;
    static Map<Integer, Integer> countMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTests = Integer.parseInt(br.readLine());

        while (numOfTests-- > 0) {
            int numOfOperations = Integer.parseInt(br.readLine());
            maxPq = new PriorityQueue<>(Collections.reverseOrder());
            minPq = new PriorityQueue<>();
            countMap = new HashMap<>();

            for (int i = 0; i < numOfOperations; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int option = Integer.parseInt(st.nextToken());

                switch (command) {
                    case "I":
                        offer(option);
                        break;
                    case "D":
                        boolean isRemoveMaxValue = option == 1;
                        if (countMap.size() == 0) {
                            break;
                        }
                        if (isRemoveMaxValue) {
                            sub(maxPq);
                            break;
                        }
                        sub(minPq);
                        break;
                    default: throw new IOException();
                }
            }
            if (countMap.size() == 0) {
                System.out.println("EMPTY");
                continue;
            }
            int maxValue = sub(maxPq);
            int minValue = countMap.size() == 0 ? maxValue : sub(minPq);

            System.out.printf("%d %d\n", maxValue, minValue);
        }
    }

    static void offer(int num) {
        minPq.offer(num);
        maxPq.offer(num);
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    static int sub(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty()) {
            int value = pq.poll();
            int countOfValue = countMap.getOrDefault(value, 0);
            if (countOfValue == 0) {
                continue;
            }
            if (countOfValue == 1) {
                countMap.remove(value);
            }
            if (countOfValue > 1) {
                countMap.put(value, countOfValue - 1);
            }
            return value;
        }
        return 0;
    }
}
