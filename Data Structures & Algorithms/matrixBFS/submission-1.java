class Solution {
    private int ROCKS = 1;
    private int LAND = 0;
    private int ROWS;
    private int COLS; 
    private int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0},
    };

    public int shortestPath(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[ROWS][COLS];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] path = q.poll();
                int row = path[0];
                int col = path[1];
                visited[row][col] = true;
                if(row == ROWS - 1 && col == COLS - 1){
                    return count;
                }

                for(int[] direction : directions){
                    int x = direction[0] + row;
                    int y = direction[1] + col;

                    if(isValid(grid, visited, x, y)){
                        q.offer(new int[]{x, y});
                    }
                }
            }
            count++;
        }
        return count;
    }

    public boolean isValid(int[][] grid, boolean[][] visited, int r, int c){
        if(Math.min(r, c) < 0 || r >= ROWS || c >= COLS || grid[r][c] == ROCKS || visited[r][c]){
            return false;
        }
        return true;
    }
}
