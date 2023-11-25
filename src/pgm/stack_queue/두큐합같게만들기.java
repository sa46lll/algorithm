package pgm.stack_queue;

import java.util.*;

public class 두큐합같게만들기 {

    public static void main(String[] args) {
        new 두큐합같게만들기().solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
        new 두큐합같게만들기().solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
        new 두큐합같게만들기().solution(new int[]{1, 1}, new int[]{1, 5});
    }

    private long sum1 = 0;
    private long sum2 = 0;
    private Queue<Integer> rQueue1 = new LinkedList();
    private Queue<Integer> rQueue2 = new LinkedList();

    public int solution(int[] queue1, int[] queue2) {
        init(queue1, queue2);
        for (int i = 0; i < 4 * queue1.length + 1; i++) {
            if (sum1 == sum2) {
                return i;
            }
            if (sum1 > sum2) {
                int n = rQueue1.peek();
                rQueue2.add(n);
                sum1 -= n;
                sum2 += n;
                rQueue1.remove();
                continue;
            }
            int n2 = rQueue2.peek();
            rQueue1.add(n2);
            sum2 -= n2;
            sum1 += n2;
            rQueue2.remove();
        }
        return -1;
    }

    private void init(int[] queue1, int[] queue2) {
        for (int i = 0; i < queue1.length; i++) {
            rQueue1.add(queue1[i]);
            sum1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            rQueue2.add(queue2[i]);
            sum2 += queue2[i];
        }
    }
}
