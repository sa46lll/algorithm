package bj.greedy;

import java.io.*;

public class 수들의합 {

    private static long sumOfNaturals;

    public static void main(String[] args) throws IOException {
        getFromUserInput();
        long n = findN(sumOfNaturals);
        System.out.println(n);
    }

    private static void getFromUserInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sumOfNaturals = Long.parseLong(br.readLine());
    }

    private static long findN(long sumOfNaturals) {
        if (sumOfNaturals == 1 || sumOfNaturals == 2) {
            return 1;
        }
        long sumOfRange = 0;
        long i = 1;
        while (true) {
            sumOfRange += i;
            if (sumOfRange > sumOfNaturals) {
                return i - 1;
            }
            i++;
        }
    }
}
