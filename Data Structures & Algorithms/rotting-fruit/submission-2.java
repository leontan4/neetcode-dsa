class Solution {
    public int[][] directions = {
            { 0, 1 },
            { 1, 0 },
            { -1, 0 },
            { 0, -1 },
    };
    public int ORANGE = 1;
    public int ROTTEN = 2;
    public int EMPTY = 0;
    public int n;
    public int m;

    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == ROTTEN) {
                    q.offer(new int[] { r, c });
                }
            }
        }

        int minutes = bfs(q, grid, -1);

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == ORANGE) {
                    return -1;
                }
            }
        }

        return minutes == -1 ? 0 : minutes;
    }

    public int bfs(Queue<int[]> q, int[][] grid, int minutes) {

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] pair = q.poll();
                int row = pair[0];
                int col = pair[1];

                for (int[] direction : directions) {
                    int x = row + direction[0];
                    int y = col + direction[1];

                    if (isValid(grid, x, y)) {
                        if (grid[x][y] == ORANGE) {
                            q.offer(new int[] { x, y });
                            grid[x][y] = ROTTEN;
                        }
                    }
                }
            }
            minutes++;
        }
        return minutes ;
    }

    public boolean isValid(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= n || grid[row][col] == ROTTEN) {
            return false;
        }
        return true;
    }
}
