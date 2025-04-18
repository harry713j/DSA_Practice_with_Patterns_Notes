package array.leetcode;

import java.util.*;

//TODO: https://leetcode.com/problems/two-sum/solutions/3619262/3-method-s-c-java-python-beginner-friendly/

public class LeetCodeEasyQuestions {
    static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2){
            return new int[]{};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

    static int removeDuplicates(int[] nums) {
        if (nums.length == 1){
            return 1;
        }

        int i = 0, j = 1;

        while (j < nums.length){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    static int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }

        int i = 0, j = nums.length - 1;

        while(i <= j){
            if(nums[i] == val){
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return j + 1;
    }

    static int[] plusOne(int[] digits) {
        int i = digits.length - 1;

        while( i >= 0 && digits[i] == 9){
            digits[i] = 0;
            i--;
        }

        if(i < 0){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        } else {
            digits[i]++;
            return digits;
        }
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }

        int i = m - 1, j = n - 1, k = m + n - 1;

        while(j >= 0){
            if (i >= 0 && nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0){
            return triangle;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for(int row = 1; row < numRows; row++){

            List<Integer> previousRow = triangle.get(row - 1);
            List<Integer> currentRow = new ArrayList<>();

            currentRow.add(1);

            for(int j = 1; j < row; j++){
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }

            currentRow.add(1);

            triangle.add(currentRow);

        }

        return triangle;
    }

    static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        int coefficient = 1;
        row.add(coefficient);

        for(int i = 1; i <= rowIndex; i++){
            coefficient = coefficient * (rowIndex - i + 1) / i;
            row.add(coefficient);
        }
        return row;
    }

    static int maxProfit(int[] prices) {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
        if (prices.length == 1){
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length ; i++){
            minPrice = Math.min(minPrice, prices[i]);

            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    static int majorityElement(int[] nums) {
    // https://leetcode.com/problems/majority-element/
//        if(nums.length == 1){
//            return nums[0];
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        int maxAppeared = Integer.MIN_VALUE;
//
//        for(int i = 0; i < nums.length; i++){
//            if (map.containsKey(nums[i])){
//                map.put(nums[i], map.get(nums[i]) + 1);
//
//                if (map.get(nums[i]) >= nums.length / 2 + 1){
//                    maxAppeared = nums[i];
//                    break;
//                }
//            } else {
//                map.put(nums[i], 1);
//            }
//        }
//
//        return maxAppeared;

        /* Boyer-Moore Voting Algorithm */
        int count = 0, candidate = 0;

        for(int num : nums){
            if (count == 0){
                candidate = num;
            }

            if (num == candidate){
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    static int[] buildArray(int[] nums) {
    // https://leetcode.com/problems/build-array-from-permutation/description/
        int n = nums.length;
        for(int i = 0; i < n; i++){
            nums[i] = nums[i] + (nums[nums[i]] % n) * n;
        }

        for(int i = 0; i < n; i++){
            nums[i] = nums[i] / n;
        }

        return nums;
    }

    static int[] shuffle(int[] nums, int n) {
    // https://leetcode.com/problems/shuffle-the-array/
        int len = nums.length;

        // to store the pair of numbers in right half of the original array
        for(int i = n; i < len; i++) {
            nums[i] = (nums[i] * 1024) + nums[i - n];
        }

        int index = 0;
        // to retrieve values from the pair of numbers and placing those retrieved value at
        // their desired position
        for(int i = n; i < len; i++, index += 2) {
            nums[index] = nums[i] % 1024;
            nums[index + 1] = nums[i] / 1024;
        }

        return nums;
    }

    static int numIdenticalPairs(int[] nums) {
    // https://leetcode.com/problems/number-of-good-pairs/
        // taking an array and keep how many occurrence of elements in array
        int result = 0;
        int[] count = new int[101];
        for (int num: nums){
            result += count[num]++;
        }

        return result;
    }

    static int[] smallerNumbersThanCurrent(int[] nums) {
    // https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
        int[] count = new int[101];

        for(int num : nums){
            count[num]++;
        }

        // accumulate the counts
        for(int i = 1; i < count.length; i++){
            count[i] = count[i] + count[i - 1];
        }

        for(int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[i] = count[nums[i] - 1];
            }
        }

        return nums;
    }

    static int[] createTargetArray(int[] nums, int[] index) {
    // https://leetcode.com/problems/create-target-array-in-the-given-order/
//        if(nums.length == 1){
//            return nums;
//        }
//
//        int n  = nums.length;
//        int[] target = new int[n];
//
//        for(int i = 0; i < n; i++){
//            int j = n - 1;
//            while(j > index[i]){
//                target[j] = target[j - 1];
//                j--;
//            }
//
//            target[index[i]] = nums[i];
//        }
//
//        return target;
        ArrayList<Integer> result = new ArrayList<>();
        int[] target = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            result.add(index[i], nums[i]);
        }

        for(int i = 0; i < result.size(); i++){
            target[i] = result.get(i);
        }

        return target;
    }

    static boolean checkIfPangram(String sentence) {
    // https://leetcode.com/problems/check-if-the-sentence-is-pangram/
        if (sentence.length() < 26){
            return false;
        }

        int[] counter = new int[26];

        for(int i = 0; i < sentence.length(); i++){
            int index = sentence.charAt(i) - 97;
            counter[index]++;
        }

        int j = 0;
        while(j < 26 && counter[j] != 0){
            j++;
        }

        return j == 26;
    }

    static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    // https://leetcode.com/problems/count-items-matching-a-rule/description/
        int count = 0;
        int index = 0;
        if (ruleKey.equals("color")) index = 1;
        if (ruleKey.equals("name")) index = 2;
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) count++;
        }
        return count;
    }

    static int largestAltitude(int[] gain) {
    // https://leetcode.com/problems/find-the-highest-altitude/
        int currentPoint = 0, maxAltitude = 0;

        for(int i = 0; i < gain.length; i++){
            currentPoint += gain[i];
            maxAltitude = Math.max(maxAltitude, currentPoint);
        }

        return maxAltitude;
    }

    static List<Integer> addToArrayForm(int[] num, int k) {
        // https://leetcode.com/problems/add-to-array-form-of-integer/
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;

        while(i >= 0 || k > 0){
            if (i >= 0){
                k += num[i];
            }

            result.add(k % 10);
            k = k / 10;
            i--;
        }

        Collections.reverse(result);
        return result;
    }

    static int[] sumZero(int n) {
    // https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
        int[] res = new int[n];
        int i = 0, j = res.length - 1;

        while(i < j){
            res[i++] = -n;
            res[j--] = n;

            n--;
        }

        return res;
    }

    static int minCostToMoveChips(int[] position) {
    // https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
        int evenCount = 0, oddCount = 0;

        for(int i = 0; i < position.length; i++){
            if (position[i] % 2 == 0){
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return Math.min(evenCount, oddCount);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
    // https://leetcode.com/problems/contains-duplicate-ii/
//        // HashMap:
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < nums.length; i++){
//            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
//                return true;
//
//            map.put(nums[i], i);
//        }
//        return false;

        // Sliding Window with HashSet:
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(i > k){
                set.remove(nums[i - k - 1]);
            }

            boolean isAdded = set.add(nums[i]);

            if(!isAdded){
                return true;
            }
        }

        return false;
    }

    static void moveZeroes(int[] nums) {
        // https://leetcode.com/problems/move-zeroes/
        int nonZeroPointer = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0)
                nums[nonZeroPointer++] = nums[i];
        }

        // fill rest of the elements with zero
        while (nonZeroPointer < nums.length){
            nums[nonZeroPointer++] = 0;
        }

//        int snowballSize = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                snowballSize++;
//            } else if (snowballSize > 0) {
//                nums[i - snowballSize] = nums[i]; // Move non-zero left
//                nums[i] = 0; // Replace current with zero
//            }
//        }
    }

    static double findMaxAverage(int[] nums, int k) {
    // https://leetcode.com/problems/maximum-average-subarray-i/
        double maxAvg = Double.NEGATIVE_INFINITY;
        int currentSum = 0, windowStart = 0;

        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];

            if(i - windowStart + 1 == k){
                maxAvg = Math.max(maxAvg, (double) currentSum / k);
                currentSum -= nums[windowStart];
                windowStart++;
            }
        }

        return maxAvg;
    }

    static List<String> summaryRanges(int[] nums) {
    // https://leetcode.com/problems/summary-ranges/

        if (nums.length == 0){
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        int first = 0;
        int last = 0;

        for (int i = 0; i < nums.length; i++){
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]){
                last++;
                i++;
            }

            if (first == last){
                result.add(nums[first] + "");
            } else {
                result.add(nums[first] + "->" + nums[last]);
            }
            last++;
            first = last;
        }


        return result;

    }

    public static void main(String[] arg){
        System.out.println("***************************OUTPUT***************************");
//        int[] nums = {2, 2, 1, 1, 1, 2, 2};
//        System.out.println(Arrays.toString(twoSum(nums, 10)));
//        System.out.println(removeDuplicates(nums));
//        System.out.println(removeElement(nums, 3));
        int[] digits = {9, 9, 9, 9};
//        System.out.println(Arrays.toString(plusOne(digits)));
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
//        System.out.println(Arrays.toString(nums1));

//        for(List<Integer> row : generate(4)){
//            System.out.println(row);
//        }

//        System.out.println(getRow(3));

        int[] prices = {7, 1, 5, 3, 6, 4};
//        System.out.println(maxProfit(prices));
//        System.out.println(majorityElement(nums));
//        int[] nums = {8, 1, 2, 2, 3};
//        System.out.println(Arrays.toString(shuffle(nums, 4)));
//        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
//        System.out.println(Arrays.toString(createTargetArray(new int[]{ 1, 2, 3, 4, 0},
//                new int[]{0, 1, 2, 3, 0})));

//        System.out.println(checkIfPangram("leetcodefsjdlaslkdjqhksjlkdjsbdjjbsdjbdh"));
//        System.out.println(addToArrayForm(new int[]{9, 9, 9, 9}, 523111));
        int[] nums = {1, 0, 2, 0, 0, 0, 0};
        moveZeroes(nums);
//        System.out.println(Arrays.toString(nums));
//        System.out.println(findMaxAverage(new int[]{-1}, 1));

        System.out.println(summaryRanges(new int[]{0, 1, 2, 5, 7, 8, 9}));

    }
}
