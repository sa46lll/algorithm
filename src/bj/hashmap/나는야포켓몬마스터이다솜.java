package bj.hashmap;

import java.io.*;
import java.util.*;

public class 나는야포켓몬마스터이다솜 {

    static Map<String, String> pokemons = new HashMap<>();

    static void solution(String pokemonInformation) {
        String value = pokemons.get(pokemonInformation);
        System.out.println(value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            String pokemonName = br.readLine();
            String pokemonNum = Integer.toString(i);
            pokemons.put(pokemonNum, pokemonName);
            pokemons.put(pokemonName, pokemonNum);
        }

        while (m-- > 0) {
            String question = br.readLine();
            solution(question);
        }
    }
}
