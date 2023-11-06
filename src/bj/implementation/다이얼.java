package bj.implementation;

import java.util.*;

public class 다이얼 {

    Map<Character, Integer> charMap = new HashMap<>();
    char[] characters;

    public static void main(String[] args) {
        new 다이얼().solution();
    }

    private void solution() {
        initializeCharMap();
        getUserInput();
        int[] values = convertCharToValue(characters);
        int sum = characters.length + sumOfValues(values);
        System.out.println(sum);
    }

    private void initializeCharMap() {
        int value = 2;
        for (int i = 65; i <= 82; i += 3) { // A부터 R까지
            charMap.put((char) (i), value);
            charMap.put((char) (i + 1), value);
            charMap.put((char) (i + 2), value);
            value++;
        }
        charMap.put('S', 7);
        charMap.put('T', 8);
        charMap.put('U', 8);
        charMap.put('V', 8);
        charMap.put('W', 9);
        charMap.put('X', 9);
        charMap.put('Y', 9);
        charMap.put('Z', 9);
    }

    private void getUserInput() {
        Scanner sc = new Scanner(System.in);
        characters = sc.next().toCharArray();
    }

    private int[] convertCharToValue(char[] characters) {
        int[] arr = new int[characters.length];
        for (int i = 0 ; i < characters.length; i++) {
            arr[i] = charMap.get(characters[i]);
        }
        return arr;
    }

    private int sumOfValues(int[] values) {
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        return sum;
    }
}
