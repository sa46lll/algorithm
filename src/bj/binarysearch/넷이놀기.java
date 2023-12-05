package bj.binarysearch;

import java.io.*;
import java.util.*;

public class 넷이놀기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(points);

//        points.forEach(System.out::println);

        int caseCount = 0;
        for (int i = 0; i < points.size(); i++) {
            int x = points.get(i).x;
            int y = points.get(i).y;
            if (!isContain(points, x + width, y) ||
                    !isContain(points, x, y + height) ||
                    !isContain(points, x + width, y + height)) {
                continue;
            }
            caseCount++;
//            System.out.println(points.get(i));
        }
        System.out.println(caseCount);
    }

    private static boolean isContain(List<Point> v, int x, int y) {
        int s = 0;
        int e = v.size() - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            Point o = new Point(x, y);
            if (v.get(mid).equals(o)) {
                return true;
            } else if (v.get(mid).x > o.x || (v.get(mid).x == o.x && v.get(mid).y > o.y)) { // 찾는게 작으면, 오른쪽을 버림
                e = mid - 1;
            } else {
                s = mid + 1; // 찾는게 크면, 왼쪽을 버림
            }
        }
        return false;
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) { // x 오름차순, y 오름차순
            if (x == o.x) {
                return y - o.y;
            }
            return x - o.x;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            Point o1 = (Point) o;
            return x == o1.x && y == o1.y;
        }
    }
}
