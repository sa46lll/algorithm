package bj.mst;

import java.io.*;
import java.util.*;

/**
 * 크루스칼 알고리즘
 */
public class 도시분할계획 {

    static int numberOfHouses;
    static House[] houses;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        promptFromUserInput();
        initParents();

        Arrays.sort(houses);

        int sum = 0;
        int maxWeight = 0;
        for (House house : houses) {
            if (find(house.from) != find(house.to)) {
                union(house.from, house.to);
                maxWeight = house.weight;
                sum += house.weight;
            }
        }
        sum -= maxWeight;
        System.out.println(sum);
    }

    private static void union(int from, int to) {
        int fromParent = find(from);
        int toParent = find(to);
        parents[toParent] = fromParent;
    }

    private static int find(int node) {
        if (parents[node] == node) {
            return node;
        }
        parents[node] = find(parents[node]);
        return parents[node];
    }

    private static void initParents() {
        parents = new int[numberOfHouses + 1];
        for (int i = 1; i <= numberOfHouses; i++) {
            parents[i] = i;
        }
    }

    private static void promptFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfHouses = Integer.parseInt(st.nextToken());
        int numberOfRoads = Integer.parseInt(st.nextToken());

        houses = new House[numberOfRoads];
        for (int i = 0; i < numberOfRoads; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            houses[i] = new House(from, to, weight);
        }
    }

    static class House implements Comparable<House> {

        int from;
        int to;
        int weight;

        public House(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(House o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
