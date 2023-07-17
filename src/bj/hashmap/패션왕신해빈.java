package bj.hashmap;

import java.io.*;
import java.util.*;

public class 패션왕신해빈 {

    static int solution(Map<String, Integer> costumes) {
        return costumes.values()
            .stream()
            .mapToInt(val -> val + 1)
            .reduce(1, (a, b) -> a * b) - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (testCase-- > 0) {
            int costumeCount = Integer.parseInt(br.readLine());
            Map<String, Integer> costumes = new HashMap<>();
            for (int i = 0; i < costumeCount; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                costumes.put(key, costumes.getOrDefault(key, 0) + 1);
            }
            int solution = solution(costumes);
            sb.append(solution).append("\n");
        }

        System.out.println(sb);
    }
}
