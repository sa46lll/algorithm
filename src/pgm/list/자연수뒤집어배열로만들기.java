package pgm.list;

import java.util.ArrayList;
import java.util.List;

class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>();

        while (n > 0) {
            list.add((int)(n % 10));
            n /= 10;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}