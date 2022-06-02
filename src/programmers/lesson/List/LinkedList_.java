package programmers.lesson.List;

import java.util.LinkedList;

public class LinkedList_ {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 5);
        list.remove(2);

        System.out.println(list.get(2));
        System.out.println(list.contains(5));
    }
}
