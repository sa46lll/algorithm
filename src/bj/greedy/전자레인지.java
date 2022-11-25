package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전자레인지 {
    static final int[] TIMES = new int[] {300, 60, 10};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] result = new int[TIMES.length];
        for (int i = 0; i < TIMES.length; i++) {
            if (t >= TIMES[i]) {
                result[i] = t / TIMES[i];
                t %= TIMES[i];
            }
        }
        StringBuffer s = new StringBuffer();
        if (t == 0) {
            for (int i = 0; i < TIMES.length; i++) {
                s.append(result[i]);
                s.append(" ");
            }
            System.out.println(s.deleteCharAt(s.length() - 1));
            return;
        }
        System.out.println(-1);
    }
}
