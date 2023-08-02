package bj.graph;

import java.io.*;
import java.util.*;

/**
 * 1. 정점별 모든 Node 생성
 * 2. Node 너비우선탐색 (bfs)
 * 3. 방문한 자식 node 중, 부모 node와 같은 색깔이 있다면 이분그래프 아님
 */
public class 이분그래프 {

    static Node[] nodes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            initNodes(br);

            boolean isBipartite = true;
            for (int i = 1; i < nodes.length; i++) {
                Node node = nodes[i];
                if (!node.visited) {
                    if (!bfs(nodes[i])) {
                        isBipartite = false;
                        break;
                    }
                }
            }
            String result = isBipartite ? "YES" : "NO";
            System.out.println(result);
        }
    }

    private static void initNodes(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfNodes = Integer.parseInt(st.nextToken());
        int numOfEdges = Integer.parseInt(st.nextToken());
        nodes = new Node[numOfNodes + 1];

        for (int i = 1; i <= numOfNodes; i++) {
            nodes[i] = new Node(i, 0);
        }

        for (int i = 0; i < numOfEdges; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].addChild(nodes[b]);
            nodes[b].addChild(nodes[a]);
        }
    }

    private static boolean bfs(Node startNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        startNode.visit();

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (!checkBipartite(node)) {
                return false;
            }

            for (Node child : node.children) {
                if (!child.visited) {
                    child.changeColor(1 - node.color);
                    child.visit();
                    queue.add(child);
                }
            }
        }
        return true;
    }

    private static boolean checkBipartite(Node node) {
        for (Node child : node.children) {
            if (child.visited && child.color == node.color) {
                return false;
            }
        }
        return true;
    }

    static class Node {
        int root;
        int color;
        boolean visited;

        List<Node> children = new ArrayList<>();

        public Node(int root, int color) {
            this.root = root;
            this.color = color;
        }

        public void addChild(Node node) {
            children.add(node);
        }

        public void changeColor(int color) {
            this.color = color;
        }

        public void visit() {
            this.visited = true;
        }
    }
}
