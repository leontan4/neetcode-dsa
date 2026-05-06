class Solution {
    private int m;
    private int n;
    private int BLANK = '#';
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(dfs(board, r, c, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int r, int c, String word, int pos){

        if(pos == word.length()) return true;
        if(!isValid(board, r, c, word, pos)) return false;
        
        board[r][c] = '#';
        boolean res = dfs(board, r + 1, c, word, pos + 1) ||
                      dfs(board, r - 1, c, word, pos + 1) ||
                      dfs(board, r, c + 1, word, pos + 1) ||
                      dfs(board, r, c - 1, word, pos + 1);

        board[r][c] = word.charAt(pos);
        return res;
    }

    public boolean isValid(char[][] board, int r, int c, String word, int pos){
        if(Math.min(r, c) < 0 || r >= m || c >= n || board[r][c] == BLANK || word.charAt(pos) != board[r][c]){
            return false;
        }
        return true;
    }
}