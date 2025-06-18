package stack.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Monotonic Stack
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // brute-force
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int curr = nums1[i];

            for (int j = 0; j < nums2.length; j++) {
                if (curr == nums2[j]){
                    int k = j + 1;
                    for (; k < nums2.length; k++) {
                        if (nums2[k] > curr){
                            ans[i] = nums2[k];
                            break;
                        }
                    }

                    // if no greater element
                    if (k >= nums2.length){
                        ans[i] = -1;
                        break;
                    }

                }
            }

        }

        return ans;
        // time: O(n^2)
        // space: O(1)
    }

    public int[] nextGreaterElementTwo(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++){
            map.put(nums1[i], i);
        }

        for (int i = nums2.length - 1; i >= 0; i--) {
            int curr = nums2[i];

            if (map.containsKey(curr)){
                while (!stack.empty() && stack.peek() <= curr){
                    stack.pop();
                }

                ans[map.get(curr)] = stack.empty() ? -1 : stack.peek();
            }

            stack.push(curr);
        }

        return ans;
        // time: O(n + m)
        // space: O(n) + O(m)
    }

    public int[] nextGreaterElementThree(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }

    public int[] nextGreaterElementFour(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = nums2.length - 1; i >= 0; i--) {
            int curr = nums2[i];

            while (!stack.empty() && stack.peek() < curr) {
                stack.pop();
            }

            if (stack.empty() || stack.peek() < curr) {
                map.put(curr, -1);
            } else {
                map.put(curr, stack.peek());
            }

            stack.push(curr);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
        // time: O(n + m)
        // space: O(n) + O(n)
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElementI().nextGreaterElementTwo(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
