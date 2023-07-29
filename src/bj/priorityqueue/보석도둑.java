package bj.priorityqueue;

import java.io.*;
import java.util.*;

public class 보석도둑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numJewelry = Integer.parseInt(st.nextToken());
        int numBag = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[numJewelry];
        for (int i = 0; i < numJewelry; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] bagMaxWeights = new int[numBag];
        for (int i = 0; i < numBag; i++) {
            bagMaxWeights[i] = Integer.parseInt(br.readLine());
        }

        solution(jewelries, bagMaxWeights);
    }

    static void solution(Jewelry[] jewelries, int[] bagMaxWeights) {
        Arrays.sort(jewelries);
        Arrays.sort(bagMaxWeights);

        PriorityQueue<Integer> jewelryPrices = new PriorityQueue<>(Collections.reverseOrder());
        long totalPrice = 0;
        int index = 0;

        for (int bagMaxWeight : bagMaxWeights) {
            while (index < jewelries.length && jewelries[index].weight <= bagMaxWeight) {
                jewelryPrices.add(jewelries[index++].price);
            }
            if (!jewelryPrices.isEmpty()) {
                totalPrice += jewelryPrices.poll();
            }
        }
        System.out.println(totalPrice);
    }

    static class Jewelry implements Comparable<Jewelry> {

        int weight;
        int price;

        Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewelry o) { // weight 오름차순, price 내림차손
            if (o.weight == weight) {
                return o.price - price;
            }
            return weight - o.weight;
        }
    }
}
