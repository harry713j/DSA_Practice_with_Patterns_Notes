package array.leetcode.easy;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

//https://takeuforward.org/plus/dsa/problems/leaders-in-an-array
public class LeadersInArray {
    public List<Integer> leaders(int[] nums) {
        // Brute-force: create a result array, from the end of the list put elements if they are the
        // greater elements among
        // e.g:- [1, 2, 5, 3, 1, 2] , n = 5
        // right most element should be present in result [2]
        // step-1: greater between element in range index n-1 and n-2
        // (here 1 is smaller than 2, as 2 already present we won't put it in result) [2]
        // step-2: greater between elements in range index n-1 and n-3(in this example 3) [2, 3]
        // after repeating it for all elements in the array [2, 3, 5]
        // now reverse it and return the result;
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = n - 1; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            // find the greater element
            for (int j = i; j < n; j++){
                if (nums[j] > max){
                    max = nums[j];
                }
            }

            if (!ans.contains(max)){
                ans.add(max);
            }
        }

        // reverse the ans and return
        Collections.reverse(ans);
        return ans;
        //time: O(n^2)
        //space: O(1)
    }

    public List<Integer> leadersTwo(int[] nums) {
        /*
        * Optimized: We take a pointer from the last elements (i) and keep track of the max element till i
        * if the ith element id greater than previous max then we store that in result and update the max
        *  */
        List<Integer> res = new ArrayList<>();
        int maxTill = Integer.MIN_VALUE;

        for (int i = nums.length - 1 ; i >= 0 ; i--) {
            if (nums[i] > maxTill){
                maxTill = nums[i];
                res.add(maxTill);
            }
        }
        // reverse the result
        Collections.reverse(res);
        return res;
        // Time: O(n)
        // Space: O(1)
    }

    public static void main(String[] args) {
        LeadersInArray l = new LeadersInArray();
        System.out.println(l.leadersTwo(new int[]{10, 22, 12, 3, 0, 6}));
    }
}
