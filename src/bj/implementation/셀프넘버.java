package bj.implementation;

public class 셀프넘버 {

    public static void main(String[] args) {
        new 셀프넘버().solution();
    }

    private boolean[] visited = new boolean[10001];

    private void solution() {
        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            executeSelf(i);
        }
        printResult();
    }

    private void executeSelf(int i) {
        int sum = i;
        // 각 자리 숫자 합 구하기
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        if (sum > 10000) {
            return;
        }
        visited[sum] = true;
        executeSelf(sum);
    }

    private void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
