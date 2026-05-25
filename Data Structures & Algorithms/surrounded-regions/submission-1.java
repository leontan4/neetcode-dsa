class Solution {
    public int[][] directions = {
            { 0, 1 },
            { 0, -1 },
            { -1, 0 },
            { 1, 0 },
    };
    public int m;
    public int n;
    public char LAND = 'O';
    public char WATER = 'X';
    public char EDGE = 'Z';

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        // for each cell in top row
        // for each cell in bottom row
        for (int c = 0; c < n; c++) {
            if (board[0][c] == LAND) {
                dfs(board, 0, c);
            }

            if (board[m - 1][c] == LAND) {
                dfs(board, m - 1, c);
            }
        }

        // for each cell in left column
        // for each cell in right column
        for (int r = 0; r < m; r++) {
            if (board[r][0] == LAND) {
                dfs(board, r, 0);
            }

            if (board[r][n - 1] == LAND) {
                dfs(board, r, n - 1);
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if(board[r][c] == LAND){
                    board[r][c] = WATER;
                }

                if (board[r][c] == EDGE) {
                    board[r][c] = LAND;
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col) {
        if (isValid(board, row, col)) {
            for (int[] direction : directions) {
                board[row][col] = EDGE;
                int x = direction[0] + row;
                int y = direction[1] + col;
                dfs(board, x, y);
            }
        }
    }

    public boolean isValid(char[][] board, int r, int c) {
        if (Math.min(r, c) < 0 || r >= m || c >= n || board[r][c] != LAND) {
            return false;
        }
        return true;
    }
}