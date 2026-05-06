class Solution {
    public int[] twoSum(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;

        while(L < R){
            int sum = nums[L] + nums[R];
            
            if(sum - target == 0){
                return new int[]{L + 1, R + 1};
            }
            else if(sum < target){
                L++;
            } else {
                R--;
            }
        }
        return new int[]{0, 0};
    }
}
