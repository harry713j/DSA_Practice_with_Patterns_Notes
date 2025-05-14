package binarysearch.leetcode.easy;

// https://leetcode.com/problems/kth-missing-positive-number/
public class KthMissingPositiveInteger {
    // intuition: if all the number present then kth missing number would be (length of array+k),
    // and all elements would have at index i-1,
    public int findKthPositive(int[] arr, int k) {
        // brute-force: we will check number from 1 to array length + k, and check how many elements are missing and return kth
        int missingCount = 1; // to track how many missing
        for (int i = 1; i <= arr.length + k; i++) {
            // linear search the elements
            boolean isFound = false;
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j]){
                    isFound = true;
                    break;
                }
            }
            if (missingCount == k && !isFound){
                return i;
            }

            if (!isFound){
                missingCount++;
            }
        }

        return  -1;
        // time: O((n+k) * n)
        // space: O(1)
    }

    public int findKthPositiveTwo(int[] arr, int k) {
        // better: shift the k by 1 if k is greater or equal to the element
        // e.g: [5, 7, 9, 11], k = 4
        // in this case the 4th missing number is 4 because 5 is greater than 4
        // if k = 6 then (1, 2, 3, 4, 5, 6) in the missing sequence 5 is out so we have to add 1 to k
        // now k = 7, (1, 2, 3, 4, 6, 7) also 7 is present in the array so increase k by 1
        // k = 8, (1, 2, 3, 4, 6, 8)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k){
                k++;
            } else {
                break;
            }
        }
        return k;
        // time: O(n)
        // space: O(1)
    }

    public int findKthPositiveThree(int[] arr, int k) {
        // optimal: using binary search check how many number are missing till index mid
        int start = 0, end = arr.length - 1;

        while (start <= end){
            int mid = (start + end) / 2;
            int missingTillMid = arr[mid] - mid - 1;

            if (missingTillMid < k){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // at last start and end will point to element between whom the ans is present
        // end will point to lower bound and start will point to upper bound
        // ans = arr[end] + k - till end element how many missing = arr[end] + k - arr[end] + end + 1
        // ans = k + end + 1 or ans = K + start
        return k + end + 1;
        // time: O(log n)
        // space: O(1)
    }
}
