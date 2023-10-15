package pgm.dfs;

public class 타겟넘버 {

    int count = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }

    private void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        int plus = sum + numbers[depth];
        int minus = sum - numbers[depth];

        dfs(numbers, target, depth + 1, plus);
        dfs(numbers, target, depth + 1, minus);
    }
}
