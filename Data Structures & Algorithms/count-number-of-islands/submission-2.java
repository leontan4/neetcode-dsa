class Solution {
    public char LAND = '1';
    public char WATER = '0';
    public int m;
    public int n;

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if(grid[r][c] == LAND){
                    count++;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (isValid(grid, r, c)) {
            grid[r][c] = WATER;
            dfs(grid, r + 1, c);
            dfs(grid, r - 1, c);
            dfs(grid, r, c + 1);
            dfs(grid, r, c - 1);
        }
    }

    public boolean isValid(char[][] grid, int r, int c) {
        if (Math.min(r, c) < 0 || r >= n || c >= m || grid[r][c] == WATER) {
            return false;
        }
        return true;
    }
}