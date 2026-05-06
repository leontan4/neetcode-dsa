class Solution {
    private char WATER = '0';
    private char LAND  = '1';
    private int ROWS;
    private int COLS;
    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        int count = 0;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == LAND){
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, boolean[][] visited, int r, int c){
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || grid[r][c] == WATER || visited[r][c]){
            return;
        }

        visited[r][c] = true;
        grid[r][c] = WATER;

        dfs(grid, visited, r + 1, c);
        dfs(grid, visited, r - 1, c);
        dfs(grid, visited, r, c + 1);
        dfs(grid, visited, r, c - 1);
        visited[r][c] = false;
    }
}
