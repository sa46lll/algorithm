package pgm.sort;

import java.util.Arrays;

public class Hindex {
    static int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i=0; i<citations.length; i++) {
            int quotationCount = citations.length - i;
            if (citations[i] >= quotationCount) {
                return quotationCount;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
    }
}
