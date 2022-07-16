package pgm.list;

import java.util.Arrays;

public class Basic_array {
    public static void main(String[] args) {
        int[] arr = new int[5];  // 0으로 초기화
        String[] strs = new String[5];  // null 초기화
        boolean[] bools = new boolean[5];  // false 초기화

        arr[0] = 1;
        arr[arr.length-1] = 5;

        System.out.println(Arrays.toString(bools));
        System.out.println(Arrays.toString(arr));
    }
}
