package bj.prefix_sum;

import java.io.*;

public class HoofPaperScissors {

    static int n;
    static int[] v;
    static int[][] map;
    static String shp = "SHP";

    public static void main(String[] args) throws IOException {
        getUserInput();
        init();

        int winCount = 0;
        for (int i = 1; i < map[0].length; i++) { // 바뀔 기준 인덱스를 정함
            for (int j = 0; j < map.length; j++) { // 첫번째 낼 선택지
                for (int k = 0; k < map.length; k++) { // 두번째 낼 선택지
                    winCount = Math.max(winCount, map[j][i - 1] + map[k][map[0].length - 1] - map[k][i - 1]);
                }
            }
        }

        System.out.println(winCount);
    }

    private static void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        v = new int[n + 1];

        for (int i = 1; i < v.length; i++) {
            char c = br.readLine().charAt(0);
            for (int j = 0; j < shp.length(); j++) {
                if (c != shp.charAt(j)) {
                    continue;
                }
                v[i] = j;
            }
        }
    }

    static void init() {
        map = new int[3][n + 1];
        for (int i = 1; i < v.length; i++) {
            for (int j = 0; j < 3; j++) {
                map[j][i] = map[j][i - 1];
            }
            map[v[i]][i]++;
        }
    }
}
