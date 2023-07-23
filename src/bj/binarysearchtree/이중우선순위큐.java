package bj.binarysearchtree;

import java.io.*;
import java.util.*;

public class 이중우선순위큐 {

    static TreeMap<Integer, Integer> treemap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTests = Integer.parseInt(br.readLine());

        while (numOfTests-- > 0) {
            int numOfOperations = Integer.parseInt(br.readLine());
            treemap = new TreeMap<>();

            for (int i = 0; i < numOfOperations; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int option = Integer.parseInt(st.nextToken());
                switch (command) {
                    case "I": {
                        offer(option);
                        break;
                    }
                    case "D": {
                        RemoveOption removeOption = RemoveOption.getRemoveOption(option);
                        if (treemap.isEmpty()) {
                            break;
                        }
                        sub(removeOption);
                        break;
                    }
                    default:
                        throw new IOException();
                }
            }
            if (treemap.isEmpty()) {
                System.out.println("EMPTY");
                continue;
            }
            System.out.printf("%d %d\n", treemap.lastKey(), treemap.firstKey());
        }
    }

    enum RemoveOption {
        REMOVE_MAX(1),
        REMOVE_MIN(-1);

        private final int input;

        RemoveOption(int input) {
            this.input = input;
        }

        public int getInput() {
            return input;
        }

        public static RemoveOption getRemoveOption(int input) {
            for (RemoveOption removeOption : RemoveOption.values()) {
                if (removeOption.getInput() == input) {
                    return removeOption;
                }
            }
            throw new IllegalArgumentException("Invalid input value");
        }

        public boolean isRemoveMax() {
            return this == REMOVE_MAX;
        }
    }

    static void offer(int option) {
        treemap.put(option, treemap.getOrDefault(option, 0) + 1);
    }

    static void sub(RemoveOption removeOption) {
        int removeKey = removeOption.isRemoveMax() ? treemap.lastKey() : treemap.firstKey();
        int countOfKey = treemap.get(removeKey);
        if (countOfKey == 1) {
            treemap.remove(removeKey);
            return;
        }
        if (countOfKey > 1) {
            treemap.put(removeKey, countOfKey - 1);
        }
    }
}
