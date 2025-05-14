package binarysearch.tuf.easy;

public class FloorAndCeil {
    public int floor(int[] nums, int x) {
        int s = 0, e = nums.length - 1;

        while (s <= e) {
            int m = (s + e) / 2;
            if (nums[m] > x) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return e;
        // time: O(log n)
        // space: O(1)
    }

    public int ceil(int[] nums, int x) {
        int s = 0, e = nums.length - 1;

        while (s <= e) {
            int m = (s + e) / 2;
            if (nums[m] > x) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return s;
        // time: O(log n)
        // space: O(1)
    }
}
