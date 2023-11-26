package bj.implementation;

import java.util.*;

public class 크로아티아알파벳 {

    private String[] croatianAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

public static void main(String[] args) {
        new 크로아티아알파벳().solution();
    }

    private void solution() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int count = 0;
        for (String croatianAlphabet : croatianAlphabets) {
            while (input.contains(croatianAlphabet)) {
                input = input.replaceFirst(croatianAlphabet, " ");
                count++;
            }
        }
        System.out.println(count + input.replace(" ", "").length());
    }
}
