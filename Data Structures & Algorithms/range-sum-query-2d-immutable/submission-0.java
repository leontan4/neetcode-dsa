class NumMatrix {

    private int[][] prefix;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefix = new int[m][n];

        for(int r=0; r<m; r++){
            prefix[r][0] = matrix[r][0];
            for(int c=1; c<n; c++){
                prefix[r][c] = prefix[r][c-1] + matrix[r][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;

        for(int r=row1; r<=row2; r++){
            if(col1 > 0){
                res += prefix[r][col2] - prefix[r][col1-1]; 
            } else{
                res += prefix[r][col2];
            }
        }

        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */