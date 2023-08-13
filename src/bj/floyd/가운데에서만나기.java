package bj.floyd;

import java.io.*;
import java.util.*;

public class 가운데에서만나기 {

    static final int INF = 987654321;
    static int numOfCities;
    static int numOfRoads;
    static int[][] graph;
    static int[] residents;
    static int[] maxTimes;
    static int minOfMaxTimes;

    public static void main(String[] args) throws IOException {
        promptFromUserInput();
        floydWarshall();
        calculateRoundTripTime();
        List<Integer> cities = getCitiesWithMinOfMaxTimes(minOfMaxTimes);
        displayResult(cities);
    }

    private static void promptFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numOfCities = Integer.parseInt(st.nextToken());
        numOfRoads = Integer.parseInt(st.nextToken());
        graph = new int[numOfCities + 1][numOfCities + 1];

        initGraph();
        fillGraph(br);
        promptResidentsInput(br);
    }

    private static void initGraph() {
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[0].length; j++) {
                graph[i][j] = i == j ? 0 : INF;
            }
        }
    }

    private static void fillGraph(BufferedReader br) throws IOException {
        for (int i = 0; i < numOfRoads; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph[start][end] = time;
        }
    }

    private static void promptResidentsInput(BufferedReader br) throws IOException {
        int numOfResidents = Integer.parseInt(br.readLine());
        residents = new int[numOfResidents];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numOfResidents; i++) {
            residents[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void floydWarshall() {
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                for (int k = 1; k < graph.length; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
    }

    private static void calculateRoundTripTime() {
        maxTimes = new int[graph.length + 1];
        minOfMaxTimes = Integer.MAX_VALUE;
        for (int i = 1; i < graph.length; i++) {
            for (int resident : residents) {
                maxTimes[i] = Math.max(maxTimes[i], graph[resident][i] + graph[i][resident]);
            }
            minOfMaxTimes = Math.min(minOfMaxTimes, maxTimes[i]);
        }
    }

    private static List<Integer> getCitiesWithMinOfMaxTimes(int minOfMaxTimes) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < maxTimes.length; i++) {
            if (maxTimes[i] == minOfMaxTimes) {
                result.add(i);
            }
        }
        Collections.sort(result);
        return result;
    }

    private static void displayResult(List<Integer> cities) {
        StringBuilder sb = new StringBuilder();
        for (int c : cities) {
            sb.append(c).append(" ");
        }
        System.out.println(sb);
    }
}
