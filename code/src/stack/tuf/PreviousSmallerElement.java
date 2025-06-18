package stack.tuf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Monotonic Stack
public class PreviousSmallerElement {
    public int[] previousSmaller(int[] num1, int[] num2){
        int[] ans = new int[num1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : num2){
            while (!stack.empty() && stack.peek() >= num){
                stack.pop();
            }

            if (!stack.empty())
                map.put(num, stack.peek());

            stack.push(num);
        }

        for (int i = 0; i < num1.length; i++) {
            ans[i] = map.getOrDefault(num1[i], -1);
        }

        return ans;
        // time: O(m + n)
        // space: O(n)
    }

    public static void main(String[] args) {
        int[] num1 = {4, 1, 2};
        int[] num2 = {1, 3, 4, 2};

        System.out.println(Arrays.toString(new PreviousSmallerElement().previousSmaller(num1, num2)));
    }
}
