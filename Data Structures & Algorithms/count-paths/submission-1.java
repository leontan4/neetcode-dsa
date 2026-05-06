class Solution {
    public int uniquePaths(int m, int n) {
        
        int[] prevRow = new int[n];

        for(int r = m - 1; r >= 0; r--){
            int[] currRow = new int[n];
            currRow[n - 1] = 1;
            
            for(int c = n - 2; c >= 0; c--){
                currRow[c] = currRow[c + 1] + prevRow[c];
            }
        prevRow = currRow;
        }
        return prevRow[0];
    }
}
