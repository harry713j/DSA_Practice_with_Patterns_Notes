package array.matrix.leetcode.easy;

public class CellsWithOddValues {
    // https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
    public int oddCells1(int m, int n, int[][] indices) {
        int[][] mat = new int[m][n]; // Space: O(m * n)

        // Time: O(s(m + n)), s -> length of the indices
        for (int[] index : indices) {
            int r = index[0];
            int c = index[1];
            int k = 0, j = 0;

            while (k < n) {
                mat[r][k++] += 1;
            }

            while (j < m) {
                mat[j++][c] += 1;
            }

        }


        int count = 0;

        // Time: O(m * n)
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] % 2 != 0){
                    count++;
                }
            }
        }

        return count;
    }

    public int oddCells(int m, int n, int[][] indices) {
        /*
        * Intuition: Instead of taking m * n 2-d array we can take two different array for row and col and increment the
        * corresponding indices, if the rowIndex[i] + colIndex[i] == odd then we count it*/
        int[] rowIndex = new int[m];
        int[] colIndex = new int[n];

        for (int[] index: indices){
            int r = index[0];
            int c = index[1];

            rowIndex[r]++;
            colIndex[c]++;

        }

        int counter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rowIndex[i] + colIndex[j]) % 2 != 0){
                    counter++;
                }
            }
        }

        return counter;
    }
}
