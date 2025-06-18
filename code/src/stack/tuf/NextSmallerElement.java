package stack.tuf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Monotonic Stack
public class NextSmallerElement {
    public int[] nextSmaller(int[] num1, int[] num2){
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[num1.length];

        for (int i = 0; i < num1.length; i++) {
            map.put(num1[i], i);
        }


        for (int i = num2.length - 1; i >= 0; i--) {
            int curr = num2[i];

            while (map.containsKey(curr) && !stack.empty() && stack.peek() >= curr){
                stack.pop();
            }

            if (map.containsKey(curr)){
                ans[map.get(curr)] = stack.empty() ? -1 : stack.peek();
            }
            // push current element to the stack
            stack.push(curr);
        }

        return ans;
        // time: O(3 * n)
        // space: O(n)
    }

    public int[] nextSmallerTwo(int[] num1, int[] num2){
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[num1.length];

        for (int num: num2){
            while (!stack.empty() && stack.peek() > num){
                map.put(stack.pop(), num);
            }

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

        System.out.println(Arrays.toString(new NextSmallerElement().nextSmallerTwo(num1, num2)));
    }
}
