package test.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class 숫자조합구하기 {

    public static String solution1(int[] numbers) {
        List<String> numberStrings = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .collect(Collectors.toList());

        // a + b와 b + a를 비교하여 오름차순으로 정렬
        numberStrings.sort((a, b) -> (a + b).compareTo(b + a));

        StringBuilder result = new StringBuilder();
        for (String s : numberStrings) {
            result.append(s);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        solution1(new int[]{11, 6, 10, 0});
        solution1(new int[]{3, 30, 5, 34, 9, 1});
    }
}
