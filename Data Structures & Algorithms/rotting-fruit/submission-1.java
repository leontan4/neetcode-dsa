class Solution {
    private final int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1},
    };
    private final int EMPTY = 0;
    private final int FRESH = 1;
    private final int ROTTEN = 2;
    private int ROWS;
    private int COLS;
    public int orangesRotting(int[][] grid) {
    
        ROWS = grid.length;
        COLS = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int totalMinutes = 0;

        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(grid[i][j] == ROTTEN){
                    q.offer(new int[]{i, j});
                }
            }
        }

        if(!q.isEmpty()){
            totalMinutes += bfs(q, grid);
        }
        
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(grid[i][j] == FRESH){
                    return -1;
                }
            }
        }
        return totalMinutes;
    }

    public int bfs(Queue<int[]> q, int[][] grid){
        int minutes = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] rotten = q.poll();
                int row = rotten[0];
                int col = rotten[1];

                for(int[] direction : directions){
                    int x = row + direction[0];
                    int y = col + direction[1];

                    if(isValid(grid, x, y)){
                        q.offer(new int[]{x, y});
                        grid[x][y] = ROTTEN;
                    }
                }
            }
            minutes++;
        }
        return minutes-1;
    }

    public boolean isValid(int[][] grid, int row, int col){
        if(Math.min(row, col)<0 || row >= ROWS || col >= COLS || grid[row][col] != FRESH) return false;
        return true;
    }
}