package datastructure;

import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(1);
        treeSet.add(100);
        treeSet.add(10);
        treeSet.add(6);
        treeSet.add(20);

        treeSet.forEach((k) -> System.out.printf("%d\n", k));

        System.out.println("10 이상의 가까운 값 : " + treeSet.ceiling(10));
        System.out.println("10 이하의 가까운 값 : " + treeSet.floor(10));
        System.out.println("10 초과의 가까운 값 : " + treeSet.higher(10));
        System.out.println("10 미만의 가까운 값 : " + treeSet.lower(10));
    }
}
