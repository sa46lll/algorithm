package bj.number_theory;

import java.io.*;

public class 보이는점의개수 {

    private boolean[][] visited;

    public static void main(String[] args) throws IOException {
        new 보이는점의개수().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        init();
        while (testCount-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int sum = 1;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (!visited[i][j]){
                        sum += 2;
                    }
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    private void init() {
        visited = new boolean[1001][1001];
        for (int i = 0; i < visited.length; i++) {
            for (int j = i + 1; j < visited.length; j++) {
                if (!visited[i][j]) {
                    for (int k = 2; k <= 1000; k++) {
                        if (!checkValidation(i * k, j * k)) {
                            break;
                        }
                        visited[i * k][j * k] = true;
                    }
                }
            }
        }
    }

    private boolean checkValidation(int x, int y) {
        return x <= 1000 && y <= 1000;
    }
}
