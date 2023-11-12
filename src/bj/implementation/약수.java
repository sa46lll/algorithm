package bj.implementation;

import java.io.*;
import java.util.*;

public class 약수 {

    private int[] arr;

    public static void main(String[] args) throws IOException {
        new 약수().solution();
    }

    private void solution() throws IOException {
        getUserInput();
        Arrays.sort(arr);
        int result;
        if (arr.length % 2 == 0) {
            result = arr[0] * arr[arr.length - 1];
        } else {
            result = arr[arr.length / 2] * arr[arr.length / 2];
        }
        System.out.println(result);
    }

    private void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
