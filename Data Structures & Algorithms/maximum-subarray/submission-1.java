class Solution {
    public int maxSubArray(int[] nums) {
        // Kadane's Algorithm
        // Two points and temp

        int maxSum = nums[0];
        int currSum = 0;

        for(int i=0; i<nums.length; i++){
            currSum = Math.max(nums[i], nums[i] + currSum);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
