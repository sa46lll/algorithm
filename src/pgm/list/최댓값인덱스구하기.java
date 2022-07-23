package pgm.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

class 최댓값인덱스구하기 { // stream으로 간결하게 표현
    public int[] 최댓값인덱스구하기(int[] arr) {

        // 최댓값 구하기
        int max = Arrays.stream(arr).max().getAsInt();

        // 인덱스 배열에 추가
        return IntStream.range(0, arr.length)
                .filter(i -> arr[i] == max)
                .toArray();
    }
}

class 최댓값인덱스구하기2 {
    public int[] 최댓값인덱스구하기2(int[] arr) {

        // 최댓값 구하기
        int max = arr[0];
        for (int i : arr) if (i > max) max = i;

        // 인덱스 리스트에 추가
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) list.add(i);
        }

        // List -> Array로 변환
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
//             int[] answer = new int[list.size()];
//             for (int i=0; i<list.size(); i++) {
//                 answer[i] = list.get(i);
//             }
         return answer;
    }
}