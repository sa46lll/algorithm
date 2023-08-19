package test.bfs;

import java.io.*;
import java.util.*;

public class 교차로에서범죄자수구하기 {

    static int numOfCrossroads; // 교차로 개수
    static int distance; // 거리
    static Node[] crossroads; // 교차로
    static boolean[] visited; // 방문 여부
    static int[] result; // 모든 테스트케이스 결과

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        result = new int[testCount + 1];

        for (int testNum = 0; testNum < testCount; testNum++) {
            promptFromUserInput(br);
            int testResult = 0;
            for (int i = 1; i < crossroads.length; i++) {
                testResult += bfs(crossroads[i]);
            }
            result[testNum] = testResult;
        }
        printResult();
    }

    private static void promptFromUserInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numOfCrossroads = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        crossroads = new Node[numOfCrossroads + 1];
        for (int i = 0; i <= numOfCrossroads; i++) {
            crossroads[i] = new Node(i);
        }
        for (int i = 0; i < numOfCrossroads - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            crossroads[a].addChild(crossroads[b]);
            crossroads[b].addChild(crossroads[a]);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numOfCrossroads; i++) {
            int isBadMan = Integer.parseInt(st.nextToken());
            if (isBadMan == 1) {
                crossroads[i].hasBadMan = true;
            }
        }
    }

    private static int bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited = new boolean[numOfCrossroads + 1]; // 방문 여부 초기화
        visited[node.root] = true;
        int currentDistance = 0;
        int numOfBadMan = 0;
        if (node.hasBadMan) {
            numOfBadMan++;
        }

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            currentDistance++;
            for (Node child : poll.children) { // 같은 거리에 있는 자식들
                if (!visited[child.root]) {
                    visited[child.root] = true;
                    queue.add(child);
                    if (child.hasBadMan) {
                        numOfBadMan++;
                    }
                }
            }
            if (currentDistance == distance) {
                break;
            }
        }
        return numOfBadMan;
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            sb.append(String.format("#%d %d", i, result[i - 1])).append("\n");
        }
        System.out.println(sb);
    }

    static class Node {

        int root;
        List<Node> children;
        boolean hasBadMan;

        public Node(int root) {
            this.root = root;
            this.children = new ArrayList<>();
        }

        public void addChild(Node child) {
            this.children.add(child);
        }
    }
}
