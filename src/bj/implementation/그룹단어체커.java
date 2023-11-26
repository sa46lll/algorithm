package bj.implementation;

import java.io.*;

public class 그룹단어체커 {

    private String[] words;

    public static void main(String[] args) throws IOException {
        new 그룹단어체커().solution();
    }

    private void solution() throws IOException {
        getUserInput();
        int count = 0;
        for (String word : words) {
            if (!isGroupWord(word)) {
                continue;
            }
            count++;
        }
        System.out.println(count);
    }

    private void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = br.readLine();
        }
    }

    private boolean isGroupWord(String word) {
        boolean[] visited = new boolean[26];
        // 첫번째 철자 방문 처리
        int lastIndex = convertToIndex(word.charAt(0));
        visited[lastIndex] = true;

        for (int c = 1; c < word.toCharArray().length; c++) {
            int index = convertToIndex(word.charAt(c));
            if (lastIndex == index) {
                continue;
            }
            if (visited[index]) {
                return false;
            }
            visited[index] = true;
            lastIndex = index;
        }
        return true;
    }

    private int convertToIndex(char c) { // a -> 0, z -> 25
        return (int) c - 97;
    }
}
