package bj.implementation;

import java.util.*;

public class 용감한용사진수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] skills = new int[n][3];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            skills[i][0] = sc.nextInt();
            skills[i][1] = sc.nextInt();
            skills[i][2] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    int count = 0;
                    for (int[] skill : skills) {
                        if (skill[0] <= skills[i][0] && skill[1] <= skills[j][1] && skill[2] <= skills[l][2]) {
                            count++;
                        }
                    }
                    if (count >= k) {
                        min = Math.min(min, skills[i][0] + skills[j][1] + skills[l][2]);
                    }
                }
            }
        }

        System.out.println(min);
    }
}
