package array.matrix.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberInMatrix {
   // https://leetcode.com/problems/lucky-numbers-in-a-matrix/
    public List<Integer> luckyNumbers1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int minIndex = 0; // col index
            // find minimum indexed number in the row
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < matrix[i][minIndex]){
                    minIndex = j;
                }
            }

            // find max index in the column of the minIndex
            int maxIndex = 0; // row index
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][minIndex] > matrix[maxIndex][minIndex]){
                    maxIndex = j;
                }
            }

            if (matrix[i][minIndex] == matrix[maxIndex][minIndex]){
                res.add(matrix[maxIndex][minIndex]);
            }

        }

        return res;
        // Time: O(m * (n + m))
        // Space: O(1)
    }

    public List<Integer> luckyNumbers2(int[][] matrix) {
        // we can keep two list, in one we will store minimum in rows and in other one we will store max in columns
        // Then we will take the intersection of elements between them, because minimum in row is also maximum in column

        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>(); // for returning the result
        List<Integer> minInRows = new ArrayList<>(); // for storing the min elements of the row

        // we are not taking the other list for max in cols because we can directly compare them

        for (int i = 0; i < m; i++) {
            int min = matrix[i][0];

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }

            minInRows.add(min);
        }

        for (int i = 0; i < n; i++) {
            int max = matrix[0][i];

            for (int j = 1; j < m; j++) {
                if (matrix[j][i] > max){
                    max = matrix[j][i];
                }
            }

            if (minInRows.contains(max)){ // if the max present in minRows then we add it to result
                res.add(max);
            }

        }

        return res;
        // Time: O(n^2)
        // Space: O(max(m, n))
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        /* Ex:
        *  1   10   4   2
        *  9   3    8   7
        *  15  16  17  12
        * Intuition: In this case the minimums are 1, 3, 12. In order to be the lucky number, 1 should be max in the col also
        * but as 3 is greater than 1 and min in that row so there is a possibilities that one number of the 3's row is greater than
        * 1 i.e. 1 < 3 < 9,8,7, therefore 1 can't be lucky number. Same logic can be applied to 3. So only 12 can or can't be
        * the lucky number. i.e. the max between the min of rows might be the lucky number. (Only one lucky number possible)
        * */

        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>(); // for returning the result
        int maxOfMinRows = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            int min = matrix[i][0];
            for (int j = 1 ; j < n; j++) {
                if (matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }

            maxOfMinRows = Math.max(maxOfMinRows, min);
        }

        for (int i = 0; i < n; i++) {
            int max = matrix[0][i];

            for (int j = 1; j < m; j++) {
                if (matrix[j][i] > max){
                    max = matrix[j][i];
                }
            }

            if (max == maxOfMinRows){
                res.add(maxOfMinRows);
                return res;
            }
        }

        return new ArrayList<>();
        // Time: O(m*n)
        // Space: O(1)
    }
}
