package bj.implementation;

import java.io.*;
import java.util.*;

public class 영수증 {

    private int totalPrice;
    private int[][] products;

    public static void main(String[] args) throws IOException {
        new 영수증().solution();
    }

    private void solution() throws IOException {
        initializeFromUserInput();
        for (int i = 0; i < products.length; i++) {
            totalPrice -= products[i][0] * products[i][1];
        }
        String result = totalPrice == 0 ? "Yes" : "No";
        System.out.println(result);
    }

    private void initializeFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalPrice = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        products = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            products[i][0] = Integer.parseInt(st.nextToken());
            products[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
