class Solution {
    public int[][] directions = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 },
    };
    public int LAND = 1;
    public int WATER = 0;
    public int m;
    public int n;
    public int area;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = Integer.MIN_VALUE;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == LAND) {
                    area = 1;
                    dfs(grid, r, c);
                    max = Math.max(max, area);
                }
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public void dfs(int[][] grid, int r, int c) {
        grid[r][c] = WATER;

        for (int[] direction : directions) {
            int x = r + direction[0];
            int y = c + direction[1];

            if (isValid(grid, x, y)) {
                area++;
                dfs(grid, x, y);
            }
        }
    }

    public boolean isValid(int[][] grid, int r, int c) {
        if (Math.min(r, c) < 0 || r >= m || c >= n || grid[r][c] == WATER) {
            return false;
        }
        return true;
    }
}