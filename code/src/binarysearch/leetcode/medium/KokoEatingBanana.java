package binarysearch.leetcode.medium;

// https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBanana {
    private int max(int[] piles){
        int maxElement = piles[0];

        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > maxElement){
                maxElement = piles[i];
            }
        }

        return maxElement;
    }

    private long calculateHours(int rate, int[] piles){
        long total = 0;
        for (int i = 0; i < piles.length; i++) {
            total += (int) Math.ceil((double) piles[i] / rate);
        }

        return total;
    }

    public int minEatingSpeed(int[] piles, int h) {
        // brute-force: run a loop from 1 to max element of array and calculate total hour taking to finish banana
        // if it is <= h then we will return it
        int maxBananaPile = max(piles);

        for (int i = 1; i <= maxBananaPile; i++) {
            long totalHours = calculateHours(i, piles);
            if (totalHours <= (long)h){
                return i;
            }
        }

        return maxBananaPile;
        // time: O(maxElement * n)
        // space: O(1)
    }

    public int minEatingSpeedTwo(int[] piles, int h) {
        // optimal: using binary search
        int maxBananaPile = max(piles);

        int start = 1, end = maxBananaPile;
        while (start <= end){
            int mid = (start + end) / 2;
            long totalHour = calculateHours(mid, piles);

            if (totalHour <=(long) h){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
        // time: O(n log (maxElement))
        // space: O(1)
    }

    public static void main(String[] args) {
        int[] piles = {805306368, 805306368, 805306368};
        System.out.println(new KokoEatingBanana().minEatingSpeedTwo(piles, 1000000000));
        System.out.println(Integer.MAX_VALUE);
    }
}
