package bj.simulation;

import java.io.*;
import java.util.*;

public class 줄세우기 {

    static final int NUM_OF_STUDENTS = 20;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numOfTestCase; i++) {
            heights = getStudentHeights(br);
            List<Integer> line = new ArrayList<>();

            int result = 0;
            for (int height : heights) { // 한명씩 줄을 선다.
                int tallerStudents = getTallerStudentsInLine(height, line);
                line.add(height);
                result += tallerStudents;
            }
            sb.append(i).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int getTallerStudentsInLine(int height, List<Integer> line) {
        int tallerStudents = 0;
        for (int h : line) {
            if (h > height) {
                tallerStudents++;
            }
        }
        return tallerStudents;
    }

    private static int[] getStudentHeights(BufferedReader br) throws IOException {
        heights = new int[NUM_OF_STUDENTS];
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        return heights;
    }
}
