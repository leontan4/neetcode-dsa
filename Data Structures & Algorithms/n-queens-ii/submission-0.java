class Solution {
    public List<List<String>> res = new ArrayList<>();
    public char EMPTY = '.';
    public char QUEEN = 'Q';

    public int totalNQueens(int n) {
        char[][] grid = new char[n][n];

        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                grid[r][c] = EMPTY;
            }
        }
        backtrack(0, grid, n);
        return res.size();
    }

    public void backtrack(int r, char[][] grid, int n){
        if(r == n){
            List<String> curr = new ArrayList<>();
            for(char[] row : grid){
                curr.add(new String(row));
            }
            res.add(curr);
            return;
        }

        for(int c=0; c<n; c++){
            if(isValid(r, c, grid)){
                grid[r][c] = QUEEN;
                backtrack(r + 1, grid, n);
                grid[r][c] = EMPTY;
            }
        }
    }

    public boolean isValid(int r, int c, char[][] grid){
        int n = grid.length;

        // Check columns
        for(int i = r - 1; i >= 0; i--){
            if(grid[i][c] == QUEEN) return false;
        }

        // Check right diagonal (pos diagonal)
        for(int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++){
            if(grid[i][j] == QUEEN) return false;
        }

        // Check left diagonal (neg diagonal)
        for(int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--){
            if(grid[i][j] == QUEEN) return false;
        }

        return true;
    }
}