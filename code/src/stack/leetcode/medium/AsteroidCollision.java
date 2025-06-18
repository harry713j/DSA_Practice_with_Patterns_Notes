package stack.leetcode.medium;

import java.util.*;

// https://leetcode.com/problems/asteroid-collision/
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            if (asteroid >= 0){
                stack.push(asteroid);
            } else {
                // collision occurred
                while (!stack.empty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }

                if (!stack.empty() && stack.peek() == Math.abs(asteroid)){
                    stack.pop();
                } else if (stack.empty() || stack.peek() < 0){
                    stack.push(asteroid);
                }

            }

        }


        int[] ans = new int[stack.size()];

        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
        // time: O(n)
        // space: O(n)
    }

    public int[] asteroidCollisionTwo(int[] asteroids) {
        // with using list
        List<Integer> stack = new ArrayList<>();

        for (int asteroid : asteroids) {

            if (asteroid >= 0){
                stack.add(asteroid);
            } else {
                // collision occurred
                while (!stack.isEmpty() && stack.getLast() > 0 && stack.getLast() < Math.abs(asteroid)) {
                    stack.removeLast();
                }

                if (!stack.isEmpty() && stack.getLast() == Math.abs(asteroid)){
                    stack.removeLast();
                } else if (stack.isEmpty() || stack.getLast() < 0){
                    stack.add(asteroid);
                }

            }

        }


        int[] ans = new int[stack.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.get(i);
        }

        return ans;
        // time: O(n)
        // space: O(n)
    }

    public static void main(String[] args) {
        int[] asteroids = {9, 8, 7, -8, -6};
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(asteroids)));
    }
}
