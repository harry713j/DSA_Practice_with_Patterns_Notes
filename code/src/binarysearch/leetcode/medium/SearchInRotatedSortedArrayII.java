package binarysearch.leetcode.medium;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchInRotatedSortedArrayII {
    // brute-force: linear search
    public boolean search(int[] nums, int target) {
        // optimal : as the array is rotated, there is two halves that are sorted,
        // we have to search in those
        // We basically compare arr[mid] with arr[low] and arr[high] in the following way:
        //
        //If arr[low] <= arr[mid]: In this case, we identified that the left half is sorted.
        //If arr[mid] <= arr[high]: In this case, we identified that the right half is sorted.
        //This check was effective in the previous problem, where there were no duplicate numbers.
        // However, in the current problem, the array may contain duplicates. Consequently,
        // the previous approach will not work when arr[low] = arr[mid] = arr[high].
        //
        //How to handle the edge case arr[low] = arr[mid] = arr[high]:
        //
        //In the algorithm, we first check if arr[mid] is the target before identifying the sorted half. I
        // f arr[mid] is not our target, we encounter this edge case. In this scenario, since arr[mid] = arr[low] = arr[high],
        // it means that neither arr[low] nor arr[high] can be the target. To handle this edge case, we simply remove arr[low] and
        // arr[high] from our search space, without affecting the original algorithm.
        //
        //To eliminate elements arr[low] and arr[high], we can achieve this by simply incrementing the low pointer and
        // decrementing the high pointer by one step. We will continue this process until the condition
        // arr[low] = arr[mid] = arr[high] is no longer satisfied.
        int start = 0, end = nums.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (nums[mid] == target){
                return true;
            }

            if (nums[start] == nums[mid] && nums[mid] == nums[end]){
                start = start + 1;
                end = end - 1;
                continue;
            }

             if (nums[mid] >= nums[start]) {
                // check in the one sorted half of the array
                if (nums[start] <= target && nums[mid] >= target){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // search in another half of the array
                if (nums[mid] <= target && nums[end] >= target){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
        // time: O(Log n)
        // space: O(1)
    }
}
