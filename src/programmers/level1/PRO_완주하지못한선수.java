package programmers.level1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
public class PRO_완주하지못한선수 {
 	static String[] participant = { "leo", "kiki", "eden" };
 	static String[] completion = { "eden", "kiki" };

 	public static void main(String[] args) throws IOException {
 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 		bw.write(solution(participant, completion));
 		bw.flush();
 		bw.close();
 	}

 	static String solution(String[] participant, String[] completion) {
 		String answer = "";
 		Arrays.sort(participant);
 		Arrays.sort(completion);
 		for (int i = 0; i < completion.length; i++) {
 			if (!participant[i].equals(completion[i])) {
 				answer += participant[i];
 				return answer;
 			}
 		}
 		answer += participant[participant.length - 1];
 		return answer;
 	}
 }
