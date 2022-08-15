package pgm.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 같은숫자는싫어 {
    static int[] solution(int []arr) {
        List<Integer> list = new LinkedList<>();

        int last = -1;
        for (int a : arr) {
            if (a == last) continue;
            last = a;
            list.add(a);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,1,3,3,0,1,1})));
        System.out.println(Arrays.toString(solution(new int[]{4,4,4,3,3})));
    }
}
