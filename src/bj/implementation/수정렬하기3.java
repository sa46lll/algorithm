package bj.implementation;

import java.io.*;
import java.util.*;

public class 수정렬하기3 {

    private int[] arr;

    public static void main(String[] args) throws IOException{
        new 수정렬하기3().solution();
    }

    private void solution() throws IOException{
        getUserInput();
        Arrays.sort(arr);
        printArray();
    }

    private void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[Integer.parseInt(br.readLine())];
        for (int i = 0 ; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private void printArray() {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
