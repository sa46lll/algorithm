package bj.implementation;

public class 정수N개의합 {

    private long sum(int[] a) {
        long sum = 0;
        for (int i : a) {
            sum += i;
        }

        return sum;
    }
}
