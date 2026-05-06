class Solution {
    private int ROWS;
    private int COLS;
    private int SPACE = 0;
    private int STONE = -1;

    public int uniquePathsWithObstacles(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        if(grid[ROWS-1][COLS - 1] == 1 || grid[0][0] == 1) return 0;
        int[][] cache = new int[ROWS][COLS];

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] != SPACE){
                    cache[r][c] = -1;
                }
            }
        }
        return memo(0, 0, cache);
    }

    public int memo(int r, int c, int[][] cache){
        if(r == ROWS || c == COLS || cache[r][c] == STONE){
            return 0;
        }

        if(cache[r][c] > 0){
            return cache[r][c];
        }

        if(r == ROWS - 1 && c == COLS - 1){
            return 1;
        }

        cache[r][c] = memo(r + 1, c, cache) + memo(r, c + 1, cache);
        return cache[r][c];
    }
}