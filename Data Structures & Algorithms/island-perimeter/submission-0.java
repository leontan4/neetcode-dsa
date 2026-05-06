class Solution {
    private int WATER = 0;
    private int LAND  = 1;
    private int m;
    private int n;
    private int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0},
    };

    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int count = 0;
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(grid[r][c] == LAND){
                    count++;
                }
            }
        }
        if(count <= 1) return count * 4;
        return (count * 4) - ((count - 1) * 2);
    }

    // public int dfs(int[][] grid, int r, int c, int count){
    //     if(Math.min(r, c) < 0 || r >= m || c >= n || grid[r][c] == WATER){
    //         return 0;
    //     }

    //     grid[r][c] = WATER;
    //     count += dfs();
    // }
}