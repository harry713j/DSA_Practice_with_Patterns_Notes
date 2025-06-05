package recursion.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParenthesis {
    // brute-force: i. n means n number of '(' and n number of ')'
    //              ii. Generate every combination of these parentheses
    //              iii. Method for checking is it a valid parentheses or not


    public List<String> generateParenthesis(int n) {
        // back-tracking:
        // conditions:
        //      1. The first choice only can be the '('
        //      2. We can choose ')' when opening count > closing count
        //      3. If opening count == n then we can only choose the closing parenthesis ')'
        List<String> ans = new ArrayList<>();
        generateParenthesisHelper(n, 0, 0, new StringBuilder(), ans);

        return ans;
        // time: O(n * Cn), Cn = Catalan Number
        // space: O(n * Cn)
    }

    private void generateParenthesisHelper(int n, int opening, int closing, StringBuilder temp, List<String> ans) {
        if (temp.length() == 2 * n){
            ans.add(temp.toString());
            return;
        }

        // `(` count is == n or count > `)` count then we can choose `)`
        if (opening < n){
            temp.append('(');
            generateParenthesisHelper(n, opening + 1, closing, temp, ans);
            // remove the parenthesis when function call leaving from call stack
            temp.deleteCharAt(temp.length() - 1);

        }

        if (opening > closing){
            temp.append(')');
            generateParenthesisHelper(n, opening, closing + 1, temp, ans);
            // remove the parenthesis when function call leaving from call stack
            temp.deleteCharAt(temp.length() - 1);
        }
    }

}
