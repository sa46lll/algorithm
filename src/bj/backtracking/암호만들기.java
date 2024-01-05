package bj.backtracking;

import java.util.*;

/**
 * 조합(3)
 */
public class 암호만들기 {

    static int l;
    static int c;
    static List<Character> alp = new ArrayList<>();
    static Character[] arr;
    static String vowels = "aeiou";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        arr = new Character[l];

        for (int i = 0; i < c; i++) {
            alp.add(sc.next().charAt(0));
        }

        Collections.sort(alp);

        recur(0, 0);
    }

    private static void recur(int cur, int start) {
        if (cur == l) {
            if (!check(arr)) {
                return;
            }
            for (char a : arr) {
                System.out.print(a);
            }
            System.out.println();
            return;
        }

        for (int i = start; i < c; i++) {
            char k = alp.get(i);
            arr[cur] = k;
            recur(cur + 1, i + 1);
        }
    }

    private static boolean check(Character[] arr) {
        int vowel = 0;
        for (char c : arr) {
            for (char s : vowels.toCharArray()) {
                if (c == s) {
                    vowel++;
                    break;
                }
            }
        }
        return vowel >= 1 && arr.length - vowel >= 2;
    }
}
