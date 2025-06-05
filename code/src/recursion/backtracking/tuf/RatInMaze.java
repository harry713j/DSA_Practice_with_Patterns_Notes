package recursion.backtracking.tuf;

import java.util.ArrayList;
import java.util.List;

// https://takeuforward.org/data-structure/rat-in-a-maze/
public class RatInMaze {
    public List<String> ratInMaze(int[][] maze) {
        List<String> ans = new ArrayList<>();

        int n = maze.length;
        boolean[][] visited = new boolean[n][n];

        solve(maze, visited, 0, 0, n, new StringBuilder(), ans);

        return ans;
        // time: O(4^(n*n))
        // space: O(n^2)
    }

    private void solve(int[][] maze, boolean[][] visited, int r, int c, int n, StringBuilder path, List<String> ans) {
        if(c == n - 1 && r == n - 1){
            ans.add(path.toString());
            return;
        }

        // first we will take D, then L then R then U for storing the answer lexicographically

        // Down
        if (r + 1 < n && maze[r + 1][c] == 1 && !visited[r + 1][c]){
            visited[r][c] = true;
            path.append('D');
            solve(maze, visited, r + 1, c, n, path, ans);
            visited[r][c] = false;
            path.deleteCharAt(path.length() - 1);
        }

        // Left
        if (c - 1 >= 0 && maze[r][c - 1] == 1 && !visited[r][c - 1]){
            visited[r][c] = true;
            path.append('L');
            solve(maze, visited, r, c - 1, n, path, ans);
            visited[r][c] = false;
            path.deleteCharAt(path.length() - 1);
        }

        // Right
        if (c + 1 < n && maze[r][c + 1] == 1 && !visited[r][c + 1]){
            visited[r][c] = true;
            path.append('R');
            solve(maze, visited, r, c + 1, n, path, ans);
            visited[r][c] = false;
            path.deleteCharAt(path.length() - 1);
        }

        // Up
        if (r - 1 >= 0 && maze[r - 1][c] == 1 && !visited[r - 1][c]){
            visited[r][c] = true;
            path.append('U');
            solve(maze, visited, r - 1, c, n, path, ans);
            visited[r][c] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] maze =  {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        List<String> ans = new RatInMaze().ratInMaze(maze);

        System.out.println(ans);
    }
}
