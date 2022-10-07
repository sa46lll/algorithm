package pgm.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

class Node {
    String name;
    List<Node> links;
    boolean visited;

    public Node(String name) {
        this.name = name;
        this.links = new LinkedList<>();
    }

    @Override
    public String toString() {
        return name;
    }

    void link(Node node) {
        links.add(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    
    void visit() {
        this.visited = true;
    }
    
    boolean isVisited() {
        return this.visited;
    }
}

public class Basic_graph {
    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        a.link(b);
        a.link(d);
        b.link(a);
        b.link(c);
        b.link(e);
        c.link(b);
        c.link(d);
        d.link(a);
        d.link(c);
        d.link(e);
        e.link(b);
        e.link(d);
        
        Node target = e;

        // BFS
        Queue<Node> queue = new LinkedList<>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            n.visit();
            System.out.println("n = " + n);
            System.out.println("queue = " + queue);

            if (n.equals(target)) {
                System.out.println("FOUND! " + n);
                break;
            }
            n.links.stream()
                    .filter(l -> !l.isVisited()) // 이미 방문한 node는 건너뜀
                    .filter(l -> !queue.contains(l)) // queue에 이미 들어가 있는 node는 건너뜀
                    .forEach(queue::offer); // 나머지 node들을 추가함

            System.out.println("queue = " + queue);
        }

        // DFS (BFS 주석 필요)
        Stack<Node> stack = new Stack<>();
        stack.push(a);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            n.visit();
            System.out.println("n = " + n);
            System.out.println("stack = " + stack);

            if (n.equals(target)) {
                System.out.println("FOUND! " + n);
                break;
            }
            n.links.stream()
                    .filter(l -> !l.isVisited())
                    .filter(l -> !stack.contains(l))
                    .forEach(stack::push);

            System.out.println("stack = " + stack);
        }
    }
}
