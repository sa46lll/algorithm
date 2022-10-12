package leetcode.string;

import java.math.BigInteger;

public class AddBinary {
    static String addBinary(String a, String b) {
        BigInteger a1 = new BigInteger(a, 2);
        BigInteger b1 = new BigInteger(b, 2);

        BigInteger sum = a1.add(b1);
        return sum.toString(2);
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }
}
