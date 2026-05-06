class Solution {
    private int ROWS;
    private int COLS;
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        this.ROWS = m;
        this.COLS = n;
        return memo(0, 0, cache);
    }

    public int memo(int r, int c, int[][]cache){
        if(r == ROWS || c == COLS){
            return 0;
        }

        if(r == ROWS - 1 && c == COLS - 1){
            return 1;
        }

        cache[r][c] = memo(r + 1, c, cache) + memo(r, c + 1, cache);
        return cache[r][c];
    }
}
