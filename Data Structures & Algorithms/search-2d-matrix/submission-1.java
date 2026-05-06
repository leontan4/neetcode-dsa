class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
int m = matrix.length;
        int n = matrix[0].length;

        for (int r = 0; r < m; r++) {
            int left = 0;
            int right = n - 1;

            while(left <= right){
                int mid = left + (right - left) / 2;
                int elem = matrix[r][mid];
                if(elem == target){
                    return true;
                } else if(elem > target){
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
