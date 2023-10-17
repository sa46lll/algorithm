package pgm.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 여행경로 {

    List<String> allRoute = new ArrayList<>();
    boolean[] visited;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", "ICN", 0);

        Collections.sort(allRoute);
        return allRoute.get(0).split(" ");
    }

    private void dfs(String[][] tickets, String start, String route, int depth) {
        if (depth == tickets.length) {
            allRoute.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], route + " " + tickets[i][1], depth + 1);
                visited[i] = false;
            }
        }
    }
}
