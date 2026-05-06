class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int L = 0;
        int R = n - 1;

        while(L <= R){
            int mid = (R + L) / 2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                R--;
            } else{
                L++;
            }
        }
        return -1;
    }
}
