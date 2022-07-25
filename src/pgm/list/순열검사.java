package pgm.list;

import java.util.Arrays;

class 순열검사 {
    public boolean 순열검사(int[] arr) {

        // O(2n + nlogn) = O(nlogn)
        int[] answer = new int[arr.length];
        for (int i=0; i<arr.length; i++) answer[i] = i+1; // O(n)
        Arrays.sort(arr); // O(nlogn)

        return Arrays.equals(answer, arr); // O(n)
    }
}