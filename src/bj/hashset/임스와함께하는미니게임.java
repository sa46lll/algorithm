package bj.hashset;

import java.io.*;
import java.util.*;

public class 임스와함께하는미니게임 {

    static final int[] playerCount = {2, 3, 4};
    static Set<String> players = new HashSet<>();
    static int game;

    public static void main(String[] args) throws IOException {
        promptFromUserInput();
        int playableGameCount = computeMaxPlayableGames();
        System.out.println(playableGameCount);
    }

    private static int computeMaxPlayableGames() {
        return players.size() / (playerCount[game] - 1);
    }

    private static void promptFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfPlayers = Integer.parseInt(st.nextToken());

        switch (st.nextToken()) {
            case ("Y"):
                game = 0;
                break;
            case ("F"):
                game = 1;
                break;
            case ("O"):
                game = 2;
                break;
            default:
                System.out.println("게임 이름을 잘못 입력하셨습니다.");
        }

        for (int i = 0; i < numOfPlayers; i++) {
            players.add(br.readLine());
        }
    }
}
