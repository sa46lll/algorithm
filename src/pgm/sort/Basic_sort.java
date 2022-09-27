package pgm.sort;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class MyData implements Comparable<MyData> {
    int v;

    public MyData(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return String.valueOf(v); // "" + v
    }

    @Override
    public int compareTo(MyData o) {
        return Integer.compare(v, o.v); // v - o.v, 오름차순
    }
}
public class Basic_sort {
    public static void main(String[] args) {
        List<MyData> list = new LinkedList<>();

        Random random = new Random();
        for(int i=0; i<20; i++) {
            list.add(new MyData(random.nextInt(50)));
        }
        list.sort(Comparator.naturalOrder());
        System.out.println("list = " + list);
    }
}
