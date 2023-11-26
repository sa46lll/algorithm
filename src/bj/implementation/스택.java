package bj.implementation;

import java.io.*;
import java.util.*;

public class 스택 {

    private StringBuilder sb = new StringBuilder();
    private Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        new 스택().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] inputs = br.readLine().split(" ");

            Command command = Command.valueOf(inputs[0].toUpperCase());
            int num = inputs.length == 2 ? Integer.parseInt(inputs[1]) : 0;

            executeCommand(command, num);
        }
        System.out.println(sb);
    }

    private void executeCommand(Command command, int n) {
        switch (command) {
            case PUSH: {
                stack.push(n);
                break;
            }
            case POP: {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                    return;
                }
                sb.append(stack.pop()).append("\n");
                break;
            }
            case SIZE: {
                sb.append(stack.size()).append("\n");
                break;
            }
            case EMPTY: {
                String s = stack.isEmpty() ? "1" : "0";
                sb.append(s).append("\n");
                break;
            }
            case TOP : {
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                    return;
                }
                sb.append(stack.peek()).append("\n");
                break;
            }
        }
    }

    private enum Command {
        PUSH, POP, SIZE, EMPTY, TOP
    }
}
