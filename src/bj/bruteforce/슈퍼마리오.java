package bj.bruteforce;

import java.io.*;

public class 슈퍼마리오 {

    private int sum = 0;
    private final int n = 10;

    public static void main(String[] args) throws IOException {
        new 슈퍼마리오().solution();
    }

    private void solution() throws IOException {
        System.out.println(getResult());
    }

    private int getResult() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            int after = sum + input;
            if (after > 100) {
                if (after + sum == 200) {
                    return after;
                }
                if (after + sum > 200) {
                    return sum;
                }
                return after;
            }
            sum += input;
        }
        return sum;
    }
}
