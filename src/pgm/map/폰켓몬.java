package pgm.map;

import java.util.*;

public class 폰켓몬 {
    static int solution(int[] nums) {
        // 폰켓몬의 종류의 갯수
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, 1);
        }
        // 최솟값 선택
        return Math.min(map.size(), nums.length / 2);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,3}));
        System.out.println(solution(new int[]{3,3,3,2,2,4}));
        System.out.println(solution(new int[]{3,3,3,2,2,2}));
    }
}
