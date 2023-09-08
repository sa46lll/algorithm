package pgm.dfs;

import static pgm.dfs.게임맵최단거리.Solution.solution;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    class Solution {

        static int[][] solutionMaps;
        static int[][] visited;
        static int[] dx = {0, 0, -1, 1};
        static int[] dy = {-1, 1, 0, 0};

        public static int solution(int[][] maps) {
            solutionMaps = maps;
            visited = new int[solutionMaps.length][solutionMaps[0].length];

            bfs(maps);
            int result = visited[solutionMaps.length - 1][solutionMaps[0].length - 1]; // 최종 목적지
            return result == 0 ? -1 : result;
        }

        private static void bfs() {
            int startX = 0;
            int startY = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startX, startY});
            visited[startX][startY] = 1;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];

                for (int i = 0; i < 4; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];
                    if (checkValidation(nextX, nextY) && visited[nextX][nextY] == 0 && solutionMaps[nextX][nextY] == 1) {
                        visited[nextX][nextY] = visited[x][y] + 1;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        private static boolean checkValidation(int x, int y) {
            return x >= 0 && x < solutionMaps.length && y >= 0 && y < solutionMaps[0].length;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                solution(new int[][]{
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}
                })
        );
    }
}
