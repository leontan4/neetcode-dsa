class Solution {
    public int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0},
    };
    public int m;
    public int n;
    public int WATER = -1;
    public int CHEST = 0;
    public int LAND = Integer.MAX_VALUE;

    public void islandsAndTreasure(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == CHEST) {
                    q.offer(new int[] {r, c});
                };
            }
        }
        bfs(q, grid);
    }

    public void bfs(Queue<int[]> q, int[][] grid) {
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] v = q.poll();
                int row = v[0];
                int col = v[1];

                for (int[] direction : directions) {
                    int x = direction[0] + row;
                    int y = direction[1] + col;

                    if (isValid(grid, x, y)) {
                        if (grid[x][y] > grid[row][col] + 1) {
                            grid[x][y] = grid[row][col] + 1;
                        }
                        q.offer(new int[] {x, y});
                    }
                }
            }
        }
    }

    public boolean isValid(int[][] grid, int r, int c) {
        if (Math.min(r, c) < 0 || r >= m || c >= n || grid[r][c] != LAND) {
            return false;
        }
        return true;
    }
}
