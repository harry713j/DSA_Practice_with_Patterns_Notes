package string.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/sort-characters-by-frequency/
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        // brute-force: determine the frequencies of each character and create answer string according to it
        int[] counts = new int[123];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counts[ch]++;
        }

        StringBuilder ans = new StringBuilder();
        int maxCount = Integer.MIN_VALUE;
        // find which one is appeared more
        for (int count: counts){
           maxCount = Math.max(maxCount, count);
        }

        for (int i = 0; i < s.length(); i++) {
            // find the index of max count
            int index = -1;
            for (int j = 0; j < counts.length; j++) {
                if (counts[j] == maxCount){
                    counts[j] = 0; // made it zero so that next time we don't get this index again
                    index = j;
                    break;
                }
            }

            if (index == -1){
                maxCount--;
            } else {
                // appending the character to the answer string
                for (int j = 0; j < maxCount; j++) {
                    ans.append((char) index);
                }
            }
        }

        return ans.toString();
        // time: O(n^2)
        // space: O(1)
    }

    public String frequencySortTwo(String s) {
        // optimal: sort of bucket-sort
        // count the frequency of characters and store them in a hashmap
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        // in another hashmap put the elements
        Map<Integer, List<Character>> bucket = new HashMap<>();
        for (Map.Entry<Character, Integer> set: counts.entrySet()){
            int frequency = set.getValue();
            char character = set.getKey();

            if (!bucket.containsKey(frequency)){
                bucket.put(frequency, new ArrayList<>());
            }
            // add character to list
            List<Character> list = bucket.get(frequency);
            list.add(character);

            bucket.put(frequency, list);
        }

        StringBuilder ans = new StringBuilder();

        for (int i = s.length(); i >= 1 ; i--) {
            boolean isPresent = bucket.containsKey(i);
            if (isPresent){
                for (char ch : bucket.get(i)){
                    for (int j = 0; j < i; j++) {
                        ans.append(ch);
                    }
                }
            }
        }

        return ans.toString();
        // time: O(n ^ 2)
        // space: O(n)
    }

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("Aabbcccdd"));
    }
}
