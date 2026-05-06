class Solution {
    private int WALL = 1;
    private int ROWS;
    private int COLS;
    public int countPaths(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        boolean[][] visited = new boolean[ROWS][COLS];

        return dfs(grid, visited, 0, 0);
    }

    public int dfs(int[][] grid, boolean[][] visited, int r, int c){
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || grid[r][c] == WALL || visited[r][c]){
            return 0;
        }

        if(r == ROWS - 1 && c == COLS - 1){
            return 1;
        }

        visited[r][c] = true;

        int count = 0;
        count += dfs(grid, visited, r + 1, c);
        count += dfs(grid, visited, r - 1, c);
        count += dfs(grid, visited, r, c + 1);
        count += dfs(grid, visited, r, c - 1);

        visited[r][c] = false;
        return count;
    }
}
