package pgm.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

class MyData {
    int v;

    public MyData(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "[" + v + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return v == myData.v;
    }

    @Override
    public int hashCode() { // 같은 v값이면 같은 해시코드 적용
        return Objects.hash(v);
    }
}

public class Basic_map {
    public static void main(String[] args) {
        Map<MyData, Integer> map = new Hashtable<>();
//        Map<String, Integer> map = new HashMap<>();
//        Map<String, Integer> map = new ConcurrentHashMap<>();

        // 데이터 생성
        map.put(new MyData(1), 11);
        map.put(new MyData(2), 12);
        map.putIfAbsent(new MyData(1), 13); // 키 값이 없을때 생성

        method1(map);
    }

    static void method1(Map<MyData, Integer> map){
        // 데이터 조회
        System.out.println(map.get(new MyData(1))); // 없으면 null
        System.out.println(map.getOrDefault(new MyData(3), -1));
        // 데이터 삭제
        map.remove(new MyData(1));
        map.remove(new MyData(1), 13); // value가 일치하지 않으면 그대로 (false)
        // 데이터 치환
        map.replace(new MyData(1), 11, 14); // oldValue가 일치하지 않으면 그대로

        System.out.println(map.values());
        System.out.println(map.keySet());
    }
}
