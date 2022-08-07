package pgm.map;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }

        var iter = map.values().iterator();
        int answer = 1;
        while (iter.hasNext()) {
            answer *= iter.next() + 1;
        }

        return answer - 1; // 모든 것을 착용하지 않는 경우의 수
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}
