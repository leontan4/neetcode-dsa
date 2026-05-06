class Solution {
    public int maxSubArray(int[] nums) {
        // Kadane's Algorithm
        // Compare two max of variables

        int currMax = 0;
        int resMax = 0;

        for(int i = 0; i < nums.length; i++){
            currMax = Math.max(0, nums[i] + currMax);
            resMax = Math.max(currMax, resMax);
        }

        return currMax <= 0 ? -1 : resMax;
    }
}
