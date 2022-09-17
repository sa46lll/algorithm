package pgm.linear_search;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class MyData implements Comparable<MyData> {
    int v;

    public MyData(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "" + v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyData myData = (MyData) o;
        return v == myData.v;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }

    @Override
    public int compareTo(MyData o) {
        return v - o.v;
    }
}

public class Basic_linearSearch {

    public static void main(String[] args) {
        List<MyData> list = new LinkedList<>();

        for (int i = 1; i < 100; i++) {
            list.add(new MyData(i));
        }
        System.out.println(list);

        int index = Collections.binarySearch(list, new MyData(63));
//        int index = list.indexOf(new MyData(63));

        System.out.println("index = " + index);
        System.out.println("value of index = " + list.get(index)); // 63
    }
}
