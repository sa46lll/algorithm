package doit;

import java.util.Scanner;

public class IndexOfTester {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("텍스트: ");
		String s1 = scan.next();	// 텍스트용 문자열
		
		System.out.print("패턴: ");
		String s2 = scan.next();	// 패턴용 문자열
		
		int idx1 = s1.indexOf(s2);		// 문자열 s1에서 s2를 검색
		int idx2 = s1.lastIndexOf(s2);	// 문자열 s1에서 s2를 검색
		
		if(idx1 == -1)
			System.out.println("텍스트 안에 패턴이 없습니다. 검색실패");
		else {
			System.out.println("가장 앞에 있는 인덱스의 값은: " + idx1);
			System.out.println("가장 마지막에 있는 인덱스의 값은: " + idx2);
		}
		
		scan.close();
	}

}
