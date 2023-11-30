package bj.dynamic;

import java.io.*;

public class 일이삼더하기 {

    private int[] arr = new int[11];

    public static void main(String[] args) throws IOException {
        new 일이삼더하기().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        dp();

        while (testCount-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[n]);
        }
    }

    private void dp() {
        for (int i = 4; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
    }
}
