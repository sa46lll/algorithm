package pgm.linear_search;

public class 문자열내p와y의개수 {
    static boolean solution(String s) {
        int p = s.replaceAll("[^pP]", "").length(); // p,P 제외
        int y = s.replaceAll("[^yY]", "").length();
        return p == y;
    }

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }
}
