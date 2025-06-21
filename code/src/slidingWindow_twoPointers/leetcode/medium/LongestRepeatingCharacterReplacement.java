package slidingWindow_twoPointers.leetcode.medium;

// https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        // brute-force: generate all the sub-string and calculate
        int maxCharacters = 0;

        for (int i = 0; i < s.length(); i++) {
            int maxFreq = 0;
            int[] hash = new int[26];

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);

                hash[ch - 'A']++;

                maxFreq = Math.max(maxFreq, hash[ch - 'A']);
                int changes = j - i + 1 - maxFreq; // number of character changes

                if (changes <= k){
                    maxCharacters = Math.max(maxCharacters, j - i + 1);
                } else {
                    break;
                }
            }

        }

        return maxCharacters;
        // time: O(n^2), Time Limit Exceeded
        // space: O(1)
    }

    public int characterReplacementTwo(String s, int k) {
        // optimal: Sliding Window
        int maxConsCharacters = 0, maxFreq = 0;
        int left = 0, right = 0;
        int[] hash = new int[26];

        while (right < s.length()){
            char ch = s.charAt(right);

            hash[ch - 'A']++;
            maxFreq = Math.max(maxFreq, hash[ch - 'A']);

            while ((right - left + 1 - maxFreq) > k){
                hash[s.charAt(left) - 'A']--;
                maxFreq = 0;
                // update the maxFreq
                for (int i = 0; i < 26; i++)
                    maxFreq = Math.max(maxFreq, hash[i]);

                left++;
            }

            maxConsCharacters = Math.max(maxConsCharacters, right - left + 1);
            right++;
        }


        return maxConsCharacters;
        // time: O(n)
        // space: O(1)
    }

    public int characterReplacementThree(String s, int k) {
        // more optimal: Sliding Window
        int maxConsCharacters = 0, maxFreq = 0;
        int left = 0, right = 0;
        int[] hash = new int[26];

        while (right < s.length()){
            char ch = s.charAt(right);

            hash[ch - 'A']++;
            maxFreq = Math.max(maxFreq, hash[ch - 'A']);

            if ((right - left + 1 - maxFreq) > k){
                hash[s.charAt(left) - 'A']--;
                maxFreq = 0;
                left++;
            }

            maxConsCharacters = Math.max(maxConsCharacters, right - left + 1);
            right++;
        }


        return maxConsCharacters;
        // time: O(n)
        // space: O(1)
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacementTwo("ABAB", 2));
    }
}
