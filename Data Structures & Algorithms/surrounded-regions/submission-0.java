class Solution {
    private char WATER = 'X';
    private char LAND  = 'O';
    private char EXTRA = 'Z';
    private int[][] directions = {
            { 0, 1 },
            { 0, -1 },
            { 1, 0 },
            { -1, 0 }
    };
    private int ROWS;
    private int COLS;

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == LAND) {
                dfs(board, r, 0);
            }

            if (board[r][COLS - 1] == LAND) {
                dfs(board, r, COLS - 1);
            }
        }

        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == LAND) {
                dfs(board, 0, c);
            }

            if (board[ROWS - 1][c] == LAND) {
                dfs(board, ROWS - 1, c);
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == LAND) {
                    board[r][c] = WATER;
                }

                if(board[r][c] == EXTRA){
                    board[r][c] = LAND;
                }
            }
        }
    }

    public void dfs(char[][] board, int r, int c) {
        if (!isValid(board, r, c)) {
            return;
        }

        board[r][c] = EXTRA;

        for (int[] direction : directions) {
            int x = direction[0];
            int y = direction[1];

            dfs(board, r + x, c + y);
        }
    }

    public boolean isValid(char[][] board, int r, int c) {
        if (Math.min(r, c) < 0 || r >= ROWS || c >= COLS || board[r][c] != LAND) {
            return false;
        }
        return true;
    }
}
