package pgm.list;

import java.util.*;

class MyData {
    int value;

    public MyData(int value) {
        this.value = value;
    }

    static MyData create(int value){
        return new MyData(value);
    }

    @Override
    public String toString() {
        return ""+value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return value == myData.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

public class Basic_list {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 5);
        list.remove(2);

        System.out.println(list.get(2)); // 인덱스 조회
        System.out.println(list.contains(5)); // Integer.valueOd(5)로 자동으로 박싱되어서 들어간다.

        List<MyData> list2 = new LinkedList<>();
        // List<MyData> list2 = new Vector<>();
        // List<MyData> list2 = new ArrayList<>(10);
        list2.add(MyData.create(1));
        list2.add(MyData.create(2));
        list2.add(MyData.create(3));

        System.out.println(list2);
        System.out.println(list.indexOf(MyData.create(2)));
        // 앞에서부터 2의 인덱스 조회
        System.out.println(list2.contains(MyData.create(2)));
        // 위와 다른 create(2) 오브젝트이므로 false 출력
        // equals 메소드를 오버라이드하면 true 출력

        method(list2);
    }

    static void method(List<MyData> list) {
        // List를 받기 때문에 LinkedList, Vector, ArrayList 등 모두 받아올 수 있음.
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
