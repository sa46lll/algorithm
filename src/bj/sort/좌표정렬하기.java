package bj.sort;

import java.io.*;
import java.util.*;

public class 좌표정렬하기 {

    private Node[] nodes;

    public static void main(String[] args) throws IOException {
        new 좌표정렬하기().solution();
    }


    private void solution() throws IOException {
        getUserInput();
        Arrays.sort(nodes);
        printNodes(nodes);
    }

    private void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nodes = new Node[n];
        for (int i = 0; i < nodes.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    private void printNodes(Node[] nodes) {
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node.toString()).append("\n");
        }
        System.out.println(sb);
    }

    class Node implements Comparable<Node> {

        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) { // x 오름차순, y 오름차순
            if (o.x == x) {
                return y - o.y;
            }
            return x - o.x;
        }

        @Override
        public String toString() {
            return String.format("%d %d", x, y);
        }
    }
}
