package recursion.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(index) == board[i][j]){
                    if(existHelper(board, word, m, n, index, i, j)){
                        return true;
                    }
                }
            }
        }

        return false;
        // time : O(m*n*4^k), k = length of word
        // space: O(k) -> depth of call stack
    }

    private boolean existHelper(char[][] board, String word, int m, int n, int index, int row, int col) {
        if (index == word.length()){
            return true;
        }

        // Checking the boundaries if the character at which we are placed is not
        //the required character
        if (row < 0 || col < 0 || row == m || col == n || word.charAt(index) != board[row][col] || board[row][col] == '!'){
            return false;
        }

        // this is to prevent reusing of the same character
        char c = board[row][col];
        board[row][col] = '!';

        boolean top = existHelper(board, word, m, n, index + 1, row - 1, col);
        boolean right = existHelper(board, word, m, n, index + 1, row, col + 1);
        boolean bottom = existHelper(board, word, m, n, index + 1, row + 1, col);
        boolean left = existHelper(board, word, m, n, index + 1, row, col - 1);

        // change the character back
        board[row][col] = c;

        return top || right || bottom || left;
    }

    public boolean existTwo(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        Set<List<Integer>> path = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existTwoHelper(board, word, path, m, n, 0, i, j)){
                    return true;
                }
            }
        }

        return false;
        // time : O(m*n*4^k), k = length of word
        // space: O(k log k)
    }

    private boolean existTwoHelper(char[][] board, String word, Set<List<Integer>> path, int m, int n, int index, int row, int col) {
        if (index == word.length()){
            return true;
        }

        // Checking the boundaries if the character at which we are placed is not
        //the required character
        if (row < 0 || col < 0 || row == m || col == n || word.charAt(index) != board[row][col] || path.contains(List.of(row, col))){
            return false;
        }

        path.add(List.of(row, col));
        boolean res = existTwoHelper(board, word, path, m, n, index + 1, row - 1, col) ||
                existTwoHelper(board, word, path, m, n, index + 1, row, col + 1) ||
                existTwoHelper(board, word, path, m, n, index + 1, row + 1, col) ||
                existTwoHelper(board, word, path, m, n, index + 1, row, col - 1);
        path.remove(List.of(row, col));

        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        System.out.println(new WordSearch().existTwo(board, word));
    }
}
