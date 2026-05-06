class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int rL = 0;
        int rR = n - 1;
        
        while(rL <= rR){
            int cL = 0;
            int cR = m - 1;
            int rMid = rL + (rR - rL) / 2;

            while(cL <= cR){
                int cMid = cL + (cR - cL) / 2;

                if(matrix[rMid][cMid] == target){
                    return true;
                } else if(matrix[rMid][cMid] > target){
                    cR = cMid - 1;
                } else{
                    cL = cMid + 1;
                }
            }
            if(cL >= m){
                rL = rMid + 1;
            } else if(cL < m){
                rR = rMid - 1;
            }
        }
        return false;
    }
}
