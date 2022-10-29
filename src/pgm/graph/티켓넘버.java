package pgm.graph;

public class 티켓넘버 {
    static int solution(int[] numbers, int target) {
        return sumCount(numbers, target, 0, 0);
    }

    static int sumCount(final int[] numbers, final int target, int i, int sum) {
        if (i == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return sumCount(numbers, target, i + 1, sum + numbers[i])
                + sumCount(numbers, target, i + 1, sum - numbers[i]);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[] {4, 1, 2, 1}, 4));
    }
}
