package bj.implementation;

import java.io.*;

public class 세로읽기 {

    private final int n = 5;
    private final int m = 15;
    private String[][] arr;

    public static void main(String[] args) throws IOException {
        new 세로읽기().solution();
    }

    private void solution() throws IOException {
        getUserInput();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ("-1".equals(arr[j][i])) {
                    continue;
                }
                sb.append(arr[j][i]);
            }
        }
        System.out.println(sb);
    }

    private void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = "-1";
            }
        }
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] stringArray = s.split("");
            for (int j = 0; j < stringArray.length; j++) {
                arr[i][j] = stringArray[j];
            }
        }
    }
}
