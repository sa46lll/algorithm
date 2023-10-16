package pgm.dfs;

public class 네트워크 {

    int networkCount = 0;
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                networkCount++;
                dfs(computers, i);
            }
        }
        return networkCount;
    }

    private void dfs(int[][] computers, int computerIndex) {
        visited[computerIndex] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[computerIndex][i] == 1 && !visited[i]) {
                dfs(computers, i);
            }
        }
    }
}
