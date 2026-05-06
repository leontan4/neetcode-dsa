class Solution {
    public int m;
    public int n;
    public Set<String> seen = new HashSet<>();
    public int[][] directions = {
            { 0, 1 },
            { 0, -1 },
            { -1, 0 },
            { 1, 0 },
    };

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        char src = word.charAt(0);

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == src) {
                    if (backtrack(r, c, board, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean backtrack(int row, int col, char[][] board, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        char c = word.charAt(index);
        String pos = row + "," + col;

        if (isValid(row, col, board, pos, c)) {
            seen.add(pos);
            for (int[] direction : directions) {
                int x = direction[0] + row;
                int y = direction[1] + col;

                if (backtrack(x, y, board, word, index + 1)) {
                    return true;
                }
            }
            seen.remove(pos);
        }
        return false;
    }

    public boolean isValid(int row, int col, char[][] board, String pos, char c) {
        if (Math.min(row, col) < 0 || row >= m || col >= n || board[row][col] != c || seen.contains(pos)) {
            return false;
        }
        return true;
    }
}