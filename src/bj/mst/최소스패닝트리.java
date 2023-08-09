package bj.mst;

import java.io.*;
import java.util.*;

/**
 * 크루스칼 알고리즘
 *
 * 1. 간선들을 가중치 오름차순으로 정렬한다.
 * 2. 가중치가 가장 작은 간선부터 연결한다.
 * 3. 사이클이 발생하는 경우 연결하지 않는다.
 * 4. 모든 노드를 연결할 때까지 2~3을 반복한다.
 */
public class 최소스패닝트리 {

    static int vertexCount;
    static int[] parents;
    static List<Node> nodes;

    public static void main(String[] args) throws IOException {
        promptFromUserInput();
        initParents();

        nodes.sort(Node::compareTo);

        int sum = 0;
        int count = 0;
        for (Node node : nodes) {
            // 두 노드의 부모가 같지 않은 경우 (사이클이 발생하지 않는 경우)
            if (find(node.from) != find(node.to)) {
                union(node.from, node.to); // 두 노드를 연결
                sum += node.weight;
                count++;

                if (count == vertexCount - 1) { // 모든 노드를 연결한 경우
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    private static void promptFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        nodes = new ArrayList<>();
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodes.add(new Node(from, to, weight));
        }
    }

    private static void initParents() {
        parents = new int[vertexCount + 1];
        for (int i = 1; i <= vertexCount; i++) {
            parents[i] = i;
        }
    }

    private static void union(int from, int to) { // 두 노드를 연결하는 메소드
        int fromParent = find(from);
        int toParent = find(to);
        parents[toParent] = fromParent; // 두 노드의 부모를 같게 만듦
    }

    private static int find(int node) { // 부모를 찾는 메소드 (재귀)
        if (parents[node] == node) {
            return node;
        }
        parents[node] = find(parents[node]);
        return parents[node];
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) { // weight 오름차순
            return this.weight - o.weight;
        }
    }
}
