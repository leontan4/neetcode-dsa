class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int L = 0;
        int currSum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int R=0; R<nums.length; R++){
            
            currSum += nums[R];
            while(currSum >= target){
                minLength = Math.min(minLength, R - L + 1);
                currSum -= nums[L];
                L++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}