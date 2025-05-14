package binarysearch.leetcode.medium;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class CapacityToShipPackage {
    // intuition: in order to carry all package the minimum capacity must be equal to max number in array,
    // and maximum capacity is summation of all elements,
    public int shipWithinDays(int[] weights, int days) {
        // brute-force: run a loop from min capacity to max capacity and calculate how many days it is taking
        int minCapacity = maximum(weights);
        int maxCapacity = sum(weights);

        for (int capacity = minCapacity; capacity <= maxCapacity ; capacity++) {
            int totalDays = calculateDays(weights, capacity);

            if (totalDays <= days){
                return capacity;
            }
        }

        return -1;
        // time: O((maxCapacity - minCapacity) * n)
        // space: O(1)
    }

    private int calculateDays(int[] weights, int capacity) {
        int days = 0, sumWeight = 0;

        for (int weight : weights) {
            sumWeight += weight;

            if (sumWeight >= capacity) {
                if (sumWeight > capacity) {
                    sumWeight = weight;
                } else {
                    sumWeight = 0;
                }
                days++;
            }
        }

        // there will be a weight so count that day too
        if (sumWeight > 0) {
            days++;
        }

        return days;
    }

    private int maximum(int[] weights) {
        int max = Integer.MIN_VALUE;

        for (int weight: weights){
            max = Math.max(max, weight);
        }

        return max;
    }

    private int sum(int[] nums){
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        return sum;
    }

    public int shipWithinDaysTwo(int[] weights, int days) {
        // optimal: we can reduce the search space between min capacity and max capacity by using binary search
        int minCapacity = maximum(weights);
        int maxCapacity = sum(weights);


        while (minCapacity <= maxCapacity){
            int mid = (minCapacity + maxCapacity) / 2;
            int totalDays = calculateDays(weights, mid);

            if (totalDays <= days){
                maxCapacity = mid - 1;
            } else {
                minCapacity = mid + 1;
            }
        }

        return minCapacity;
        // time: O(n * log (max_capacity - min_capacity))
        // space: O(1)
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(new CapacityToShipPackage().shipWithinDays(arr, 5));
    }
}
