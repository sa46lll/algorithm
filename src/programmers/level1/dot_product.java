package programmers.level1;

import java.io.IOException;
import java.util.ArrayList;

public class dot_product {
    public static void main(String[] args) throws IOException {
        Solution2 sol = new Solution2();
        int[] a = {1, 2, 3, 4};
        int[] b = {-3,-1,0,2};
        int result = sol.solution(a, b);
        System.out.println(result);
    }
}

class Solution2 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i=0; i<a.length; i++){
            answer += a[i]*b[i];
        }
        return answer;
    }
}