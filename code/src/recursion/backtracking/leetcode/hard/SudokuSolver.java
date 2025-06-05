package recursion.backtracking.leetcode.hard;

// https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
        // time: O(9^(n ^ 2)
        // : lets say every cell is empty then for each cell we have 9 choices therefor , for 81 empty cell we have 9^81 choice i.e. 9^(9^2)
        // space: O(1)
    }

    private boolean solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.'){
                    for (char ch = '1';  ch <= '9' ; ch++) {
                        if (isValid(board, i, j, ch)){

                            board[i][j] = ch;

                            if (solve(board)){
                                return true;
                            } else {
                                board[i][j] = '.';
                            }

                        }
                    }

                    return false;
                }

            }
        }
        
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char ch){
        // checking if the number is already present in the row or column or grid

        for (int i = 0; i < 9; i++) {

            // checking in the row
            if (board[row][i] == ch){
                return false;
            }

            // column
            if (board[i][col] == ch){
                return false;
            }

            // sub-grid
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch){
                return false;
            }

        }

        return true;
    }
}
