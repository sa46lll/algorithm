package pgm.set;

import java.util.HashSet;
import java.util.Set;

public class 로또번호검출기 {
    static boolean solution(int[] lotto) {
        Set<Integer> set = new HashSet<>();
        for (int i : lotto) {
            if (i>=1 && i<=45) set.add(i);
        }
        return set.size() == 6;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 7, 32, 43, 22, 19}));
        System.out.println(solution(new int[]{3, 19, 34, 39, 39, 20}));
    }
}
