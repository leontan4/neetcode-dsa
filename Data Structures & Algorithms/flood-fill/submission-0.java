class Solution {
    public int[][] directions = {
            { 0, 1 },
            { 1, 0 },
            { -1, 0 },
            { 0, -1 }
    };
    public int m;
    public int n;
    public int PIXEL;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;

        if(image[sr][sc] == color) return image;
        PIXEL = image[sr][sc];
        dfs(image, sr, sc, color);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color) {
        if (isValid(image, r, c)) {
            image[r][c] = color;
            for (int[] direction : directions) {
                int x = direction[0] + r;
                int y = direction[1] + c;
                dfs(image, x, y, color);
            }
        }
    }

    public boolean isValid(int[][] images, int r, int c) {
        if (Math.min(r, c) < 0 || r >= m || c >= n || images[r][c] != PIXEL) {
            return false;
        }
        return true;
    }
}