package datastructure;

import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        treeMap.put(5, 1);
        treeMap.put(3, 1);
        treeMap.put(7, 1);
        treeMap.put(100, 1);

        int firstKey = treeMap.firstKey();
        int lastKey = treeMap.lastKey();

        System.out.println("가장 작은 키 = " + firstKey);
        System.out.println("가장 큰 키 = " + lastKey);
        System.out.println("firstKey 이상의 큰 키 = " + treeMap.ceilingKey(firstKey));
        System.out.println("lastKey 이하의 작은 키 = " + treeMap.floorKey(lastKey));
        System.out.println("firstKey 초과의 작은 키 = " + treeMap.higherKey(firstKey));
        System.out.println("lastKey 미만의 작은 키 = " + treeMap.floorKey(lastKey));
        System.out.println("firstKey 이상의 작은 key = " + treeMap.ceilingEntry(firstKey).getKey());
        System.out.println("lastKey 이하의 작은 value = " + treeMap.floorEntry(lastKey).getValue());

        treeMap.forEach((k, v) -> System.out.printf("%d %d\n", k, v));
    }
}
