package pgm.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class 주식가격 {
    static int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        int[] answer = new int[prices.length]; // 리턴 값은 항상 prices 길이와 같다.

        for (int p : prices) {
            queue.add(p);
        }

        int idx = 0;
        int n = queue.poll();
        while (!queue.isEmpty()) {
            int count = 0;
            for (int i = idx+1; i < prices.length; i++) {
                count++;
                if (n > prices[i]) break;
            }
            answer[idx] = count;
            n = queue.poll();
            idx++;
        }
        answer[idx] = 0;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 2, 3}));
    }
}
