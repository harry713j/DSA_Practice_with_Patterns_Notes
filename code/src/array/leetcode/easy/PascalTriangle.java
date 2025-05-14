package array.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        // if numRows == 0 then have to return empty triangle
        if (numRows == 0){
            return triangle;
        }

        // add first row [1]
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        // create and add rest of the rows
        for (int row = 1; row < numRows; row++) {
            // we need previous row for calculating the current row elements
            List<Integer> prevRow = triangle.get(row - 1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1); // add first element as 1
            for (int col = 1; col < row; col++) {
                // current row element is equal to previous row's same index element + previous row's index-1 element
                currentRow.add(prevRow.get(col - 1) + prevRow.get(col));
            }
            // add 1 at last too
            currentRow.add(1);
            // add current row to the triangle
            triangle.add(currentRow);
        }

        return triangle;
        // time: O(n^2)
        // space: O(n^2)
        // imp: https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/
    }
}
