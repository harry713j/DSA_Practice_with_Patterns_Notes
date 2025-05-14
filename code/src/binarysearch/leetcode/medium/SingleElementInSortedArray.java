package binarysearch.leetcode.medium;

// https://leetcode.com/problems/single-element-in-a-sorted-array/
public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        // brute-force: as the array is sorted, the duplicate elements placed adjacent to each other
        // we will check if the previous element is same as current element then we will eliminate that element
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                ans -= nums[i]; // we can also use XOR(^)
            } else {
                ans += nums[i];
            }
        }

        return ans;
        // time: O(n)
        // space: O(1)
    }

    public int singleNonDuplicateTwo(int[] nums) {
        // optimal: as the array is sorted we can use binary search
        // https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/
        // handling the edge cases
        if (nums.length == 1){
            return nums[0];
        }

        if (nums[0] != nums[1]){
            return nums[0];
        }

        if (nums[nums.length - 1] != nums[nums.length - 2]){
            return nums[nums.length - 1];
        }

        int start = 1, end = nums.length - 2;
        while (start <= end){
            int mid = (start + end) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
                return nums[mid];
            }
            // [1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6]
            // from the single element to left the firsts number of pair is at even index and the 2nd number of pair is at odd index
            // from the single element to right the 1st number of pair is at odd index and 2nd number of pair is at even index
            // condition for eliminating the left half
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])){
                start = mid + 1;
            } else { // else eliminate the right half
                end = mid - 1;
            }
        }

        return -1;
        // time: O(log n)
        // space: O(1)
    }

    public static void main(String[] args) {
        SingleElementInSortedArray s = new SingleElementInSortedArray();
        int[] arr = {7, 7, 10, 11, 11, 12, 12};
        System.out.println(s.singleNonDuplicateTwo(arr));
    }
}
