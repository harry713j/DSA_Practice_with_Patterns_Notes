package slidingWindow_twoPointers.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fruit-into-baskets/
public class FruitsIntoBasket {
    public int totalFruit(int[] fruits) {
        // brute-force:
        Map<Integer, Integer> basket = new HashMap<>();
        int maxFruits = 0;

        for (int i = 0; i < fruits.length; i++) {
            int type1 = -1, type2 = -1; // storing the type of fruit

            for (int j = i; j < fruits.length; j++) {
                if (basket.isEmpty()){
                    type1 = fruits[j];
                    basket.put(type1, 1);
                } else if (basket.size() == 1 && type1 != fruits[j]){
                    type2 = fruits[j];
                    basket.put(type2, 1);
                } else if (type1 == fruits[j] || type2 == fruits[j]){
                    basket.put(fruits[j], basket.get(fruits[j]) + 1);
                } else {
                    break;
                }
                int total = basket.getOrDefault(type1, 0) + basket.getOrDefault(type2, 0);
                maxFruits = Math.max(maxFruits, total);
            }

            basket.clear();
        }

        return maxFruits;
        // time: O(n^2) , Time Limit Exceeded
        // space: O(1) // map taking constant space -> 2
    }

    public int totalFruitTwo(int[] fruits) {
        // optimal: Sliding Window
        Map<Integer, Integer> basket = new HashMap<>();
        int maxFruits = 0, l = 0, r = 0;

        while (r < fruits.length){
            basket.put(fruits[r], basket.getOrDefault(fruits[r], 0) + 1);

            while (basket.size() > 2){
                basket.put(fruits[l], basket.get(fruits[l]) - 1);

                if (basket.get(fruits[l]) == 0){
                    basket.remove(fruits[l]);
                }

                l++;
            }

            int total = r - l + 1;
            maxFruits = Math.max(maxFruits, total);

            r++;
        }

        return maxFruits;
        // time: O(n)
        // space: O(1)
    }

    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};

        System.out.println(new FruitsIntoBasket().totalFruit(fruits));
    }
}
