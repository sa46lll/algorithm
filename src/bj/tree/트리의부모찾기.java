package bj.tree;

import java.io.*;
import java.util.*;

public class 트리의부모찾기 {

    static Node[] tree;
    static int[] parentNode;

    public static void main(String[] args) throws IOException {
        initNode();
        /**
         * v1) bfs
         */
        bfs();

        /**
         * v2) bfs
         */
        dfs(tree[1]);
        
        displayParentNodeNumber();
    }

    private static void initNode() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfNodes = Integer.parseInt(br.readLine());
        tree = new Node[numOfNodes + 1];
        parentNode = new int[numOfNodes + 1];
        for (int i = 1; i <= numOfNodes; i++) {
            tree[i] = new Node(i);
        }
        while (--numOfNodes > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].addChild(tree[b]);
            tree[b].addChild(tree[a]);
        }
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree[1]);
        tree[1].visit();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node child : node.children) {
                if (!child.visited) {
                    parentNode[child.root] = node.root;
                    child.visit();
                    queue.add(child);
                }
            }
        }
    }

    private static void dfs(Node node) {
        node.visit();
        for (Node child : node.children) {
            if (!child.visited) {
                System.out.println(child.root);
                parentNode[child.root] = node.root;
                dfs(child);
            }
        }
    }

    private static void displayParentNodeNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < parentNode.length; i++) {
            sb.append(parentNode[i]).append("\n");
        }
        System.out.println(sb);
    }

    static class Node {
        int root;
        boolean visited;
        List<Node> children = new ArrayList<>();

        Node(int root) {
            this.root = root;
        }

        public void addChild(Node node) {
            this.children.add(node);
        }

        public void visit() {
            this.visited = true;
        }
    }
}
