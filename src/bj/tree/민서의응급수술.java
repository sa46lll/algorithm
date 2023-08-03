package bj.tree;

import java.io.*;
import java.util.*;

/**
 * 트리가 되기 위해 연결하거나 해제해야하는 간선의 최소한의 개수
 * = 연결해야 하는 간선의 수 + 해제해야 하는 간선의 수
 * = (그룹수 - 1) + (모두 연결되어있을때 간선의 수 - 트리가 됐을때의 간선의 수)
 * = (그룹수 - 1) + (m + 그룹수 - 1) - (n - 1)
 */
public class 민서의응급수술 {

    static int numOfNeurons;
    static int numOfSynapse;
    static List<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        promptForUserInput();
        int numOfGroup = 0;
        for (int i = 1; i < tree.length; i++) {
            if (!visited[i]) {
                numOfGroup++;
                dfs(i);
            }
        }
        int numSynapsesToConnect = numOfGroup - 1;
        int numEdges = numOfNeurons - 1;
        int numSynapsesToDisconnect = numOfSynapse + numSynapsesToConnect - numEdges;
        System.out.println(numSynapsesToConnect + numSynapsesToDisconnect);
    }

    private static void dfs(int i) {
        visited[i] = true;
        List<Integer> children = tree[i];
        for (int child : children) {
            if (!visited[child]) {
                visited[child] = true;
                dfs(child);
            }
        }
    }

    private static void promptForUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numOfNeurons = Integer.parseInt(st.nextToken());
        numOfSynapse = Integer.parseInt(st.nextToken());

        tree = new ArrayList[numOfNeurons + 1];
        visited = new boolean[numOfNeurons + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < numOfSynapse; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
    }
}
