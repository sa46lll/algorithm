package pgm.linear_search;

import java.util.Arrays;

public class 전화번호목록 {
    static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i=1; i<phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123","456","789"}));
        System.out.println(solution(new String[]{"12","123","1235","567","88"}));
    }
}
