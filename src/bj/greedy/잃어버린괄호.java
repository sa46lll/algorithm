package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        String[] expressionGroup = expression.split("-");

        List<Integer> list = new ArrayList<>();
        for (String s : expressionGroup) {
            int sum = 0;
            String[] plusNums = s.split("\\+");
            for (String plusNum : plusNums) {
                sum += Integer.parseInt(plusNum);
            }
            list.add(sum);
        }
        long result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result -= list.get(i);
        }
        System.out.println(result);
    }
}
