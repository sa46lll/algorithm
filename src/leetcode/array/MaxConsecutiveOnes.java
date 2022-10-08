package leetcode.array;

public class MaxConsecutiveOnes {
    private static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count += 1;
                continue;
            }
            maxCount = Math.max(count, maxCount);
            count = 0;
        }
        return Math.max(count, maxCount);
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
    }
}
