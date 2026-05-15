class Solution {
    public int[][] directions = {
        { 0, 1 }, { 0, -1 },
        { 1, 0 },{ -1, 0 },
        { 1, 1 },{ 1, -1 },
        { -1, 1 },{ -1, -1 },
    };
    public int PATH = 0;
    public int WALL = 1;
    public int n;

    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        n = grid.length;
        if (grid[0][0] != PATH || grid[n - 1][n - 1] != PATH)
            return -1;

        q.offer(new int[] { 0, 0 });
        grid[0][0] = 1;

        while (!q.isEmpty()) {
            int[] edges = q.poll();
            int row = edges[0];
            int col = edges[1];

            for (int[] direction : directions) {
                int x = direction[0] + row;
                int y = direction[1] + col;

                if (isValid(grid, x, y)) {
                    grid[x][y] = grid[row][col] + 1;
                    q.offer(new int[] { x, y });
                }
            }
        }

        int shortest = grid[n - 1][n - 1];
        return shortest == 0 ? -1 : shortest;
    }

    public boolean isValid(int[][] grid, int r, int c) {
        if (Math.min(r, c) < 0 || r >= n || c >= n || grid[r][c] != PATH) {
            return false;
        }
        return true;
    }
}