package bj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String word = br.readLine();

        StringBuffer nextString = new StringBuffer(text);
        int count = 0;
        while(nextString.indexOf(word) != -1) {
            int end = nextString.indexOf(word) + word.length();
            nextString.delete(0, end);
            count++;
        }
        System.out.println(count);
    }
}
