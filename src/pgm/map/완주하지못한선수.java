package pgm.map;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    static String solution(String[] participant, String[] completion) {
        // Map
        Map<String, Integer> players = new HashMap<>();

        for (String p : participant) { // O(n)
            players.put(p, players.getOrDefault(p, 0) + 1); // 원래 있던 값 +1
        }

        for (String c : completion) {
            int n = players.get(c) -1;
            if (n == 0) players.remove(c);
            else players.put(c, n);
            // players.put(c, players.getOrDefault(p, 0) - 1); // 원래 있던 값 -1
        }

        return players.keySet().iterator().next(); // O(1)
        // keySet은 Set<String> 타입이기 때문에 iterator 사용

        // List (시간 초과)
        /*
        List<String> players = new LinkedList<>();

        for (String p : participant) players.add(p);
        for (String c : completion) players.remove(c);
        // LinkedList이기 때문에 처음부터 끝까지 찾는 과정에서 오래 걸림

        return players.get(0);
        */

        // Sort
        /*
        Arrays.sort(participant); // O(nlogn)
        Arrays.sort(completion);

        for (int i=0; i<completion.length; i++) {
            if (!participant[i].equals(completion[i])) return participant[i];
        }

        return participant[participant.length - 1];
        */
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}));
        System.out.println(solution(
                new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(
                new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}));
    }
}
