package bj.sort;

import java.io.*;
import java.util.*;

public class 나이순정렬 {

    static Member[] members;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        members = new Member[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members[i] = new Member(i, Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(members);
        StringBuilder sb = new StringBuilder();
        for (Member m : members) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.println(sb);
    }

    static class Member implements Comparable<Member> {
        int id;
        int age;
        String name;

        Member(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) { // age 오름차순, id 오름차순
            if (age == o.age) {
                return id - o.id;
            }
            return age - o.age;
        }
    }
}
