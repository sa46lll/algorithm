package leetcode.array;

public class FindNumbersWithEvenNumberOfDigits {
    private static int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (checkEvenNumberOfDigits(num)) {
                result += 1;
            }
        }
        return result;
    }

    private static boolean checkEvenNumberOfDigits(int num) {
        int length = String.valueOf(num).length();
        return length % 2 == 0;
    }
    
    private static int checkEvenCount(int num) {
        int result = 0;
        while (num > 0) {
            int n = num % 10;
            if (n % 2 == 0) {
                result += 1;
            }
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[] {12,345,2,6,7896}));
        System.out.println(findNumbers(new int[] {555,901,482,1771}));
    }
}
