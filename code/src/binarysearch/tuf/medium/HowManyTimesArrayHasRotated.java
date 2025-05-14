package binarysearch.tuf.medium;

//https://takeuforward.org/arrays/find-out-how-many-times-the-array-has-been-rotated/
public class HowManyTimesArrayHasRotated {
    // intuition: in a perfectly sorted array the minimum element should be at the 0th index, by using this we can find how many times
    // array is rotated, if minimum index at 0 index then not rotated if any other index then it is rotated that many times
    // brute-force: traverse the array and find the index of minimum element

    public int countRotation(int[] nums){
        // optimal: using binary search find the index of minimum element;
        int s = 0, e = nums.length - 1;
        int minIndex = -1, minElement = Integer.MAX_VALUE;

        while (s <= e){
            int m = (s + e) / 2;
            // check for the sorted half the first element of the sorted part is minimum and eliminate that part
            if (nums[s] <= nums[m]){
                if (nums[s] < minElement){
                    minIndex = s;
                    minElement = nums[s];
                }
                s = m + 1;
            } else {
                if (nums[m] < minElement){
                    minIndex = m;
                    minElement = nums[m];
                }
                e = m - 1;
            }
        }

        return minIndex;
        // time: O(log n)
        // space: O(1)
    }
}
