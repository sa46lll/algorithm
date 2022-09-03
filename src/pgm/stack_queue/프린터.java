package pgm.stack_queue;

import java.util.LinkedList;
import java.util.List;

public class 프린터 { // 큐를 이용해야할 것 같지만 리스트를 이용하자
    static class Paper {
        boolean isMine;
        int priority;
        Paper(int p, boolean m) {
            priority = p;
            isMine = m;
        }

        @Override
        public String toString() {
            return "" + isMine +priority;
        }
    }

    static int solution(int[] priorities, int location) {
        List<Paper> list = new LinkedList<>();
        // 중간값을 조회해야하므로 큐스택보다는 리스트가 낫다.
        for (int p=0; p < priorities.length; p++) {
            list.add(new Paper(priorities[p], p == location));
        }

        int answer = 1;
        while (!list.isEmpty()) {
            Paper now = list.remove(0);

            boolean printable = true;
            for (Paper p : list) {
                if (now.priority < p.priority) {
                    printable = false;
                    break;
                }
            }
            if (!printable) {
                list.add(now);
                continue;
            }
            if (!now.isMine) {
                answer++;
                continue;
            }
            break;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
