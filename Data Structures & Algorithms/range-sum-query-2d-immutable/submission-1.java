class NumMatrix {
    public int[][] prefix;
    int n;

    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        prefix = new int[n][n];

        for(int r=0; r<n; r++){
            prefix[r][0] = matrix[r][0];

            for(int c=1; c<n; c++){
                prefix[r][c] = prefix[r][c-1] + matrix[r][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int r=row1; r<=row2; r++){
            
            if(col1 == 0){
                sum += prefix[r][col2];
                continue;
            }
            sum += prefix[r][col2] - prefix[r][col1-1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */