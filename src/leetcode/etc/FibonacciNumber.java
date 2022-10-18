package leetcode.etc;

public class FibonacciNumber {
    static int fib(int n) {
        if (n == 0 || n == 1) { // O(n)=2^n
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib(4));
        System.out.println(fib(3));
        System.out.println(fib(2));
    }
}
