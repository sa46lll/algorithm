package pgm.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class MyData {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return v == myData.v;
    }

    @Override
    public int hashCode() { // HashMap은 내부에 HashTable을 사용하고 있기 때문에 해시값이 필요
        return Objects.hash(v);
    }
}

public class Basic_set {
    public static void main(String[] args) {
        Set<MyData> setA = new HashSet<>();
        Set<MyData> setB = new HashSet<>();
//        Set<MyData> set = new LinkedHashSet<>();

        // A
        setA.add(new MyData(1));
        setA.add(new MyData(2));
        setA.add(new MyData(3));
        // B
        setB.add(new MyData(2));
        setB.add(new MyData(3));
        setB.add(new MyData(4));

        // A + B (합집합)
        setA.addAll(setB);
        // A - B (차집합)
        setA.removeAll(setB);
        // A * B (교집합)
        setA.retainAll(setB);

        System.out.println(setA);
    }
}
