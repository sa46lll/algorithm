package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 대회or인턴 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        int maxTeam = Math.min(n / 2, m);
        if (n + m - maxTeam * 3 < k) {
            int rest = n + m - maxTeam * 3;
            maxTeam -= Math.ceil((k - rest) / 3.0);
        }
        System.out.println(maxTeam);
    }
}
