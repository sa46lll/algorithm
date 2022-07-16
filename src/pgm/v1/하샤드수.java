package pgm.v1;

import java.io.IOException;
public class 하샤드수 {
    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        boolean result = sol.solution(10);
        System.out.println(result);
    }
}

// 하샤드 수
class Solution {
    public boolean solution (int x) throws IOException {
        int sum = 0;
        int a = x;

        while (a >= 1) {
            sum += a % 10;
            a /= 10;
        }

        if (x % sum == 0) {
            return true;
        } else
            return false;
    }
}