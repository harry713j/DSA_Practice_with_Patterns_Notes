package binarysearch.leetcode.medium;

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
public class MaxNumberOfDaysToMakeBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        // brute-force: all the flower can be bloomed between minimum and maximum number of days,
        // we will check between them if the required bouquet can be formed or not
        if (bloomDay.length < m * k){
            return -1;
        }
        int minDay = minimum(bloomDay);
        int maxDay = maximum(bloomDay);

        // check between min and max day
        for (int day = minDay; day <= maxDay; day++) {
            // calculate how many bouquet can be possible
            int noOfBouquet = calculateBouquet(bloomDay, day, k);
            if (noOfBouquet >= m){
                return day;
            }
        }

        return -1;
        // time: O((max - min) * n)
        // space: O(1)
    }

    private int minimum(int[] arr){
        int min = Integer.MAX_VALUE;

        for (int element: arr){
            if (element < min){
                min = element;
            }
        }

        return min;
    }

    private int maximum(int[] arr){
        int max = Integer.MIN_VALUE;

        for (int element: arr){
            if (element > max){
                max = element;
            }
        }

        return max;
    }

    private int calculateBouquet(int[] bloomDay, int day, int k){
        int count = 0, bouquet = 0;
        for (int j = 0; j < bloomDay.length; j++) {
            if (bloomDay[j] <= day){
                count++;
            } else {
                bouquet += count / k;
                count = 0;
            }
        }

        // if count is > 0 there can be possible bouquet
        bouquet += count / k;

        return bouquet;
    }

    public int minDaysTwo(int[] bloomDay, int m, int k) {
        // all the flower can be bloomed between minimum and maximum number of days,
        // optimal : as we are searching in a range we can apply binary search to reduce the lookups
        // if number of flower is less than required then we can't make bouquet even after max day
        long totalFlowerRequired =(long) m * k;
        if (totalFlowerRequired > bloomDay.length){
            return -1;
        }

        int start = minimum(bloomDay); // min day
        int end = maximum(bloomDay); // max day

        while (start <= end){
            int mid = (start + end) / 2;
            int noOfBouquet = calculateBouquet(bloomDay, mid, k);

            // if the required number of bouquet are formed then answer could be that mid or below that
            if (noOfBouquet >= m){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
        // time: O(n log(max - min))
        // space: O(1)
    }

    public static void main(String[] args) {
        int[] arr = {1,10,3,10,2};
        System.out.println(new MaxNumberOfDaysToMakeBouquets().minDaysTwo(arr, 3, 1));
    }
}
