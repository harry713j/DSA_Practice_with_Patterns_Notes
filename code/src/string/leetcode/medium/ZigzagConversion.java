package string.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/zigzag-conversion/
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        // brute-force
        if (numRows == 1){
            return s;
        }

        List<List<Character>> ds = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            ds.add(new ArrayList<>());
        }
        StringBuilder ans = new StringBuilder();
        int row = 0, direction = 1; // track row , direction = 1 means down -1 mean up

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            ds.get(row).add(c);

            if (row == 0){
                direction = 1;
            } else if (row == numRows - 1) {
                direction = -1;
            }

            row += direction;
        }

        // retrieve the ans from the ds
        for (List<Character> r : ds){
            for (char c : r){
                ans.append(c);
            }
        }

        return ans.toString();
        // time: O(n)
        // space: O(n)
    }

    public String convertTwo(String s, int numRows) {
        // optimal
        if (numRows == 1){
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int currRow = 0;
        boolean isGoingDown = false;

        for (char c : s.toCharArray()){
            rows.get(currRow).append(c);

            if (currRow == 0 || currRow == numRows - 1){
                isGoingDown = !isGoingDown;
            }

            if (isGoingDown){
                currRow++;
            } else {
                currRow--;
            }

        }

        // retrieve the answer
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows){
            res.append(row);
        }

        return res.toString();
        // time: O(n)
        // space: O(n)
    }
}
