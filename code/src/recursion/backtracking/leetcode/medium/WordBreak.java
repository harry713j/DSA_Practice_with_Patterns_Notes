package recursion.backtracking.leetcode.medium;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

// https://leetcode.com/problems/word-break/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict); // Convert to Set for O(1) average lookup
        return canBreak(s, wordDictSet);
        // time: O(2^n)
        // space: O(n)
    }

    private boolean canBreak(String s, Set<String> wordDictSet) {
        // Base case: If the string is empty, it means we successfully segmented it
        if (s.isEmpty()) {
            return true;
        }

        // Iterate through all possible prefixes of the current string 's'
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i); // Get the prefix

            // If the prefix is a valid word in the dictionary
            if (wordDictSet.contains(prefix)) {
                String suffix = s.substring(i); // Get the remaining suffix

                // Recursively check if the remaining suffix can also be broken down
                if (canBreak(suffix, wordDictSet)) {
                    return true; // If the suffix can be broken, then this path is successful
                }
            }
        }

        // If no prefix leads to a successful segmentation of the entire string
        return false;
    }
}
