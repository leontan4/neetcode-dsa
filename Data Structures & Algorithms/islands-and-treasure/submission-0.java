class Solution {
    private int WATER = -1;
    private int CHEST = 0;
    private int INF   = Integer.MAX_VALUE;
    private int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0},
    };
    private int m;
    private int n;

    public void islandsAndTreasure(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == CHEST){
                    q.offer(new int[]{r, c});
                }
            }
        }

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int row = pair[0];
            int col = pair[1];

            for(int[] direction : directions){
                int x = direction[0] + row;
                int y = direction[1] + col;

                if(isValid(grid, x, y)){
                    q.offer(new int[]{x, y});
                    grid[x][y] = grid[row][col] + 1;
                }
            }
        }
    }

    public boolean isValid(int[][] grid, int r, int c){
        if(Math.min(r, c) < 0 || r >= m || c >= n || grid[r][c] != INF){
            return false;
        }
        return true;
    }
}
