package recursion.backtracking.tuf;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceWithSumK {

    public void printSubsequenceWithSumK(int[] nums, int index, List<Integer> ds, int sum, int n, int k) {
        if (index == n) {
            if (sum == k) {
                System.out.println(ds);
            }
            return;
        }
        // pick
        ds.add(nums[index]);
        sum += nums[index];
        printSubsequenceWithSumK(nums, index + 1, ds, sum, n, k);
        ds.remove(ds.size() - 1);
        sum -= nums[index];

        // don't pick
        printSubsequenceWithSumK(nums, index + 1, ds, sum, n, k);
        // time: O(2^n)
        // space: O(n)
    }

    public boolean printAnySubsequenceWithSumK(int[] nums, int i, List<Integer> ds, int sum, int n, int k){
        if (i == n){
            if (sum == k){
                System.out.println(ds);
                return true;
            }
            else return false;
        }

        // pick
        ds.add(nums[i]);
        sum += nums[i];

        if (printAnySubsequenceWithSumK(nums, i + 1, ds, sum, n, k)){
            return true;
        }

        ds.remove(ds.size() - 1);
        sum -= nums[i];

        if (printAnySubsequenceWithSumK(nums, i + 1, ds, sum, n, k)){
            return true;
        }

        return false;
        // time: O(2^n)
        // space: O(n)
    }

    public int countSubsequenceWithSumK(int[] nums, int index,int sum, int n, int k) {
        if (index == n) {
            if (sum == k)
                return 1;
            else
                return 0;
        }
        // pick

        sum += nums[index];
        int left = countSubsequenceWithSumK(nums, index + 1,  sum, n, k);

        sum -= nums[index];

        // don't pick
        int right = countSubsequenceWithSumK(nums, index + 1, sum, n, k);

        return left + right;
        // time: O(2^n)
        // space: O(n)
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        List<Integer> ds = new ArrayList<>();

        SubsequenceWithSumK ss = new SubsequenceWithSumK();

//        ss.printSubsequenceWithSumK(nums, 0, ds, 0, nums.length, 2);
        ss.printAnySubsequenceWithSumK(nums, 0, ds, 0, nums.length, 2);

        System.out.println(ss.countSubsequenceWithSumK(nums, 0, 0, nums.length, 2));
    }
}
