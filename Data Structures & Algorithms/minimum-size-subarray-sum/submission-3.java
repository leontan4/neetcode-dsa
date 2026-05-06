class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int L = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(int R = 0; R < nums.length; R++){
            sum += nums[R];

            while(sum >= target){
                min = Math.min(R - L + 1, min);
                sum -= nums[L];
                L++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}