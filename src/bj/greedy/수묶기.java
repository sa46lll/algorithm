package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        List<Integer> positiveList = new ArrayList<>();
        List<Integer> negativeOrZeroList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 1) {
                result++;
                continue;
            }
            if (num > 0) {
                positiveList.add(num);
                continue;
            }
            negativeOrZeroList.add(num);
        }
        Collections.sort(positiveList);
        Collections.sort(negativeOrZeroList);

        result = calculatePositiveExceptOneMaximum(result, positiveList);
        result = calculateNegativeMaximum(result, negativeOrZeroList);
        System.out.println(result);
    }

    private static int calculateNegativeMaximum(int result, List<Integer> negativeOrZeroList) {
        if (negativeOrZeroList.size() == 1) {
            result += negativeOrZeroList.get(0);
        } else {
            for (int i = 0; i < negativeOrZeroList.size() - 1; i += 2) {
                result += negativeOrZeroList.get(i) * negativeOrZeroList.get(i + 1);
                if (i == negativeOrZeroList.size() - 3) {
                    result += negativeOrZeroList.get(negativeOrZeroList.size() - 1);
                }
            }
        }
        return result;
    }

    private static int calculatePositiveExceptOneMaximum(int result, List<Integer> positiveList) {
        if (positiveList.size() == 1) {
            result += positiveList.get(0);
            return result;
        }
        for (int i = positiveList.size() - 1; i >= 0; i -= 2) {
            result += positiveList.get(i) * positiveList.get(i - 1);
            if (i == 2) {
                result += positiveList.get(0);
                break;
            }
        }
        return result;
    }
}
