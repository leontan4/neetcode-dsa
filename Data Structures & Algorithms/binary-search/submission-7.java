class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int L = 0;
        int R = n - 1;

        while(L <= R){
            int mid = L + (R - L) / 2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                R = mid - 1;
            } else{
                L = mid + 1;
            }
        }
        return -1;
    }
}
