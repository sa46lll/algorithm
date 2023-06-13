package bj.recursion;

import java.io.*;

public class 재귀함수가뭔가요 {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursion(n, 0);
        System.out.println(sb);
    }

    private static void recursion(int n, int count) {
        printUnderLine(count);
        sb.append("\"재귀함수가 뭔가요?\"\n");
        if (n == 0) {
            printUnderLine(count);
            sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            printUnderLine(count);
            sb.append("라고 답변하였지.\n");
            return;
        }
        printUnderLine(count);
        sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        printUnderLine(count);
        sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        printUnderLine(count);
        sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        recursion(--n, ++count);
        printUnderLine(count - 1);
        sb.append("라고 답변하였지.\n");
    }

    private static void printUnderLine(int count) {
        for (int i = 0; i < count; i++) {
            sb.append("____");
        }
    }
}
