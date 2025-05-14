package string.leetcode.easy;

// https://leetcode.com/problems/largest-odd-number-in-string/
public class LargestOddNumberInString {
    public String largestOddNumber(String num) {
        // brute-force: produce all the possible substrings of the string and compare their value

        if (Character.getNumericValue(num.charAt(num.length() - 1)) % 2 != 0){
            return num;
        }

        StringBuilder ans = new StringBuilder(); // store the possible answer

        for (int i = 0; i < num.length(); i++) {
            // forming the sub-strings
            for (int j = i; j < num.length(); j++) {
                StringBuilder temp = new StringBuilder(); // store the temporary answer
                temp.append(num, i, j + 1);

                // compare the values of temp and ans
              if (Character.getNumericValue(temp.charAt(temp.length() - 1)) % 2 != 0) {
                    // then we need to check their length
                    // if they have different length then we will assign the greater length string to ans,
                    // otherwise we will compare each digit
                    if (temp.length() > ans.length()){
                        ans = new StringBuilder(temp);
                        temp = new StringBuilder();
                    } else if (temp.length() == ans.length()) {
                        for (int k = 0; k < ans.length(); k++) {
                            if (Character.getNumericValue(temp.charAt(k)) > Character.getNumericValue(ans.charAt(k))){
                                ans = new StringBuilder(temp);
                                temp = new StringBuilder();
                                break;
                            }
                        }
                    }
                }

            }
        }

        return ans.toString();
        // time: O(n^3)
        // space: O(n)
    }

    public String largestOddNumberTwo(String num) {
        // optimal: we traverse from right of the string if we find an odd digit then from the beginning to that index is our answer
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0){
                return num.substring(0, i + 1);
            }
        }
        // if we come out of the loop that means no odd digit
        return "";
        // time: O(n)
        // space: O(1)
    }

    public static void main(String[] args) {
        System.out.println(new LargestOddNumberInString().largestOddNumber("35472"));
    }
}
