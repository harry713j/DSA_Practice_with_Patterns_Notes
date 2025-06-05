package recursion.backtracking.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /*
    * Intuition: 1. Every row will contain only one queen
    *             2. Every column will contain only one queen
    *             3. No queen should not attack another in any 8 possible direction
    * */
    public List<List<String>> solveNQueens(int n) {
        // brute-force: back-tracking
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, board, ans);

        return ans;
        // time: O(n! * n)
        // space: O(n ^ 2)
    }

    private void solve(int col, char[][] board, List<List<String>> ans) {
        if (col == board.length){
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)){
                board[row][col] = 'Q';
                // put 'Q' in next col
                solve(col + 1, board, ans);
                // back-track
                board[row][col] = '.';
            }
        }

    }

    private boolean isSafe(char[][] board, int row, int col) {
        // we need to check if we can put 'Q' in the corresponding row and col in the 3 direction on the left,
        // because other 5 directions are not filled or to be filled

        int tempRow = row;
        int tempCol = col;

        // left-upper-diagonal
        while (tempRow >= 0 && tempCol >= 0){
            if (board[tempRow][tempCol] == 'Q'){
                return false;
            }
            tempRow--;
            tempCol--;
        }

        // left-horizontal
        tempRow = row;
        tempCol = col;
        while (tempCol >= 0){
            if (board[tempRow][tempCol] == 'Q'){
                return false;
            }
            tempCol--;
        }

        // left-lower-diagonal
        tempCol = col;

        while (tempRow < board.length && tempCol >= 0){
            if (board[tempRow][tempCol] == 'Q'){
                return false;
            }
            tempRow++;
            tempCol--;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();

        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }

        return res;
    }

    public List<List<String>> solveNQueensTwo(int n) {
        // optimal: back-tracking
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // we will use array hashing to check if the row and diagonal have 'Q' or not
        boolean[] leftRow = new boolean[n];
        boolean[] leftUpperDiagonal = new boolean[2 * n - 1];
        boolean[] leftLowerDiagonal = new boolean[2 * n - 1];

        solveTwo(0, board,leftRow, leftUpperDiagonal, leftLowerDiagonal, ans);

        return ans;
        // time: O(n! * n)
        // space: O(n ^ 2)
    }

    private void solveTwo(int col, char[][] board, boolean[] leftRow, boolean[] leftUpperDiagonal, boolean[] leftLowerDiagonal, List<List<String>> ans) {
        if (col == board.length){
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (!leftRow[row] && !leftLowerDiagonal[row + col] && !leftUpperDiagonal[board.length - 1 + col - row]){
                board[row][col] = 'Q';
                leftRow[row] = true;
                leftUpperDiagonal[board.length - 1 + col - row] = true;
                leftLowerDiagonal[row + col] = true;

                solveTwo(col + 1, board, leftRow, leftUpperDiagonal, leftLowerDiagonal, ans);
                // back-track
                board[row][col] = '.';
                leftRow[row] = false;
                leftUpperDiagonal[board.length - 1 + col - row] = false;
                leftLowerDiagonal[row + col] = false;
            }
        }
    }


    public static void main(String[] args) {
        List<List<String>> ans = new NQueens().solveNQueensTwo(4);

        for (List<String> s : ans){
            System.out.println(s);
        }
    }

}
