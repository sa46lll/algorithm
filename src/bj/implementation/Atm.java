package bj.implementation;

import java.io.*;
import java.util.*;

public class Atm {

    private int[] arr;

    public static void main(String[] args) throws IOException {
        new Atm().solution();
    }

    private void solution() throws IOException {
        getUserInput();
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * (arr.length - i);
        }
        System.out.println(sum);
    }

    private void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
