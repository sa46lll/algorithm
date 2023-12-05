package bj.implementation;

import java.io.*;
import java.util.*;

public class 큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] c = br.readLine().split(" ");
            Command command = Command.valueOf(c[0].toUpperCase());
            switch (command) {
                case PUSH: {
                    deque.add(Integer.parseInt(c[1]));
                    break;
                }
                case POP: {
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                }
                case SIZE: {
                    sb.append(deque.size()).append("\n");
                    break;
                }
                case EMPTY: {
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                }
                case FRONT: {
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.getFirst()).append("\n");
                    }
                    break;
                }
                case BACK: {
                    if (deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.getLast()).append("\n");
                    }
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    enum Command {
        PUSH, POP, SIZE, EMPTY, FRONT, BACK
    }
}
