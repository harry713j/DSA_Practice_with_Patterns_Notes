package array.leetcode.hard;

public class LeetCodeHardQuestions {
    static int[] merge(int[] nums1, int[] nums2){
        int i = 0, j = 0, k = 0;
        int[] merged = new int[nums1.length + nums2.length];

        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                merged[k] = nums1[i];
                i++;
            } else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < nums1.length){
            merged[k++] = nums1[i++];
        }

        while(j < nums2.length){
            merged[k++] = nums2[j++];
        }
        return merged;
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0){
            return 0;
        }

        int[] merged = merge(nums1, nums2);

        return merged.length % 2 == 0 ? (merged[merged.length / 2] + merged[merged.length / 2 - 1]) / 2.0
                : merged[merged.length / 2];
    }

    static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        // Ensure nums1 is the smaller array for simplicity
        if (n1 > n2)
            return findMedianSortedArrays2(nums2, nums1);

        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2; // Calculate the left partition size
        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) >> 1; // Calculate mid index for nums1
            int mid2 = left - mid1; // Calculate mid index for nums2

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            // Determine values of l1, l2, r1, and r2
            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                // The partition is correct, we found the median
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }
            else if (l1 > r2) {
                // Move towards the left side of nums1
                high = mid1 - 1;
            }
            else {
                // Move towards the right side of nums1
                low = mid1 + 1;
            }
        }

        return 0; // If the code reaches here, the input arrays were not sorted.
    }

    static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    static int firstMissingPositive(int[] nums) {
    // https://leetcode.com/problems/first-missing-positive/

        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]){
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j + 1)
                return j + 1;
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 7, 11, 15};
        int[] nums2 = {1, 4, 12, 17, 20};
//        System.out.println(findMedianSortedArrays2(nums1, nums2));

        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
