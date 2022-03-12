package programmers.level1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class random_sum {
    public static void main(String[] args) throws IOException {
        Solution3 sol = new Solution3();
        int[] a = {2,1,3,4,1};
        int[] result = sol.solution(a);
        System.out.println(result);
    }
}

class Solution3 {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = numbers[i] + numbers[j];
                if (list.indexOf(a) < 0) {
                    list.add(a);
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }
}