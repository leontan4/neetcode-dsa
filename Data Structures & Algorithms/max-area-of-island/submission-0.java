class Solution {
    private int WATER = 0;
    private int LAND = 1;
    private int ROWS;
    private int COLS;
    private int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int max = 0;

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == LAND){
                    max = Math.max(max, dfs(grid, r, c));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int r, int c){
        if(Math.min(r ,c) < 0 || r >= ROWS || c >= COLS || grid[r][c] == WATER){
            return 0;
        }

        grid[r][c] = WATER;
        int count = 0;
        for(int[] path : directions){
            int x = path[0];
            int y = path[1];
            count += dfs(grid, r + x, c + y);
        }
        return count + 1;
    }
}