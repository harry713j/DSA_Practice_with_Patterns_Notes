package array.leetcode.medium;

import java.util.*;

// https://leetcode.com/problems/3sum/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // brute-force: Run three loops and check if the elements sum up to zero
        Set<List<Integer>> ansSet = new HashSet<>(); // for unique triplets
        int  n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                        Collections.sort(list); // sorted it because triplet must be unique
                        ansSet.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(ansSet);
        // time: O(n^3)
        // space: O(n)
    }

    public List<List<Integer>> threeSumTwo(int[] nums) {
        // better approach: Sort the array, then for each element search two element
        // which would add up to 0 by two pointer method
        Set<List<Integer>> ansSet = new HashSet<>();
        int n = nums.length;
        // sort the array
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right){
                if (nums[left] + nums[right] == -nums[i]){
                    ansSet.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return new ArrayList<>(ansSet);
        // time: O(n^2)
        // space: O(n)
    }

    public List<List<Integer>> threeSumThree(int[] nums) {
        // another better approach:
        Set<List<Integer>> ansSet = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            Set<Integer> set = new HashSet<>();
            // here we will look for element in hash set -(nums[i] + nums[j])
            for (int j = i + 1; j < n; j++) {
                int rem = - (nums[i] + nums[j]);
                if (set.contains(rem)){
                    List<Integer> list = new ArrayList<>(List.of(nums[i], nums[j], rem));
                    list.sort(null);
                    ansSet.add(list);
                }
                set.add(nums[j]);
            }
        }

        return new ArrayList<>(ansSet);
        // time: O(n^2)
        // space: O(n)
    }

    public List<List<Integer>> threeSumFour(int[] nums) {
        // optimal: extended version of sort and two pointer (2nd approach)
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        // sort the array
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            // as the array is sorted for same element the same triplets can be possible we will ignore it
            // that's how we can get rid of set
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    ans.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // skip the duplicates from left and right
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
        // time: O(n^2)
        // space: O(1)
    }
}
