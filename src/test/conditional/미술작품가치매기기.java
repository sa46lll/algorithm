package test.conditional;

import java.util.Arrays;

public class 미술작품가치매기기 {

    public static int solution(int[] prices, int d, int k) {
        Arrays.sort(prices);
        int[] sortedPrices = Arrays.stream(prices).sorted().toArray();

        if (isPriceDifferenceWithinLimit(sortedPrices, d)) {
            return getAverage(sortedPrices);
        }
        if (isPriceDifferenceWithinLimitExcludingExtremePrices(sortedPrices, d)) {
            return getAverage(sortedPrices);
        }
        if (getRandomKAverage(sortedPrices, d, k) != 0) {
            return getRandomKAverage(sortedPrices, d, k);
        }
        return getMedian(sortedPrices);
}

    /**
     * 가장 비싼 책정가와 가장 싼 책정가의 차가 d 이하인지 반환
     */
    private static boolean isPriceDifferenceWithinLimit(int[] sortedPrices, int d) {
        return sortedPrices[sortedPrices.length - 1] - sortedPrices[0] <= d;
    }

    /**
     * 가장 비싸고, 가장 싼 책정가를 제외한 가장 비싸고 가장 싼 책정가의 차가 d원 이하인지 반환
     */
    private static boolean isPriceDifferenceWithinLimitExcludingExtremePrices(int[] sortedPrices, int d) {
        return sortedPrices[sortedPrices.length - 2] - sortedPrices[1] <= d;
    }

    /**
     * 임의의 k개의 작품의 평균값 반환
     */
    private static int getRandomKAverage(int[] sortedPrices, int d, int k) {
        for (int i = 0; i < sortedPrices.length; i++) {
            if (i + k > sortedPrices.length) {
                break;
            }
            if (sortedPrices[i + k - 1] - sortedPrices[i] <= d) {
                int sum = 0;
                for (int j = i; j < i + k; j++) {
                    sum += sortedPrices[j];
                }
                return sum / k;
            }
        }
        return 0;
    }

    /**
     * 중앙값 반환
     */
    private static int getMedian(int[] sortedPrices) {
        if (sortedPrices.length % 2 != 0) {
            return sortedPrices[sortedPrices.length / 2];
        }
        return sortedPrices[sortedPrices.length / 2 - 1];
    }

    private static int getAverage(int[] prices) {
        int sum = 0;
        for (int price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 5, 6, 7, 8}, 4, 3)); // 1번 방법
        System.out.println(solution(new int[]{4, 5, 6, 7, 8}, 2, 1)); // 2번 방법
        System.out.println(solution(new int[]{4, 5, 6, 7, 8}, 1, 2)); // 3번 방법
        System.out.println(solution(new int[]{8, 4, 5, 7, 6}, 1, 3)); // 3번 방법
        System.out.println(solution(new int[]{1, 8, 1, 8, 1, 8}, 6, 4)); // 4번 방법
    }
}
