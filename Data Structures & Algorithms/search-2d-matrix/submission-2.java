class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int rL = 0;
        int rR = n - 1;


        // target = 10
        // [[1,2,4,8],[10,11,12,13],[14,20,30,40]]

        // target = 3  || 13
        // [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
        
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

            System.out.println("cL: " + cL);
            System.out.println("cR: " + cR);
            System.out.println("rL: " + rL);
            System.out.println("rR: " + rR);
            System.out.println("rMid: " + rMid);
            System.out.println("target: " + target);
            
            System.out.println();
            if(cL >= m){
                rL = rMid + 1;
            } else if(cL < m){
                rR = rMid - 1;
            }
        }
        return false;
    }
}
