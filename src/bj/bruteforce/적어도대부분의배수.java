package bj.bruteforce;

import java.io.*;
import java.util.*;

public class 적어도대부분의배수 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        getUserInput();
        for (int i = 1; i <= 1000000; i++) {
            int count = 0;
            for (int j : arr) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                System.out.println(i);
                return;
            }
        }
    }

    private static void getUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
