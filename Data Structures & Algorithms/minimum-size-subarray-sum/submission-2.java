class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int L = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int R = 0; R < nums.length; R++) {
            sum += nums[R];

            while (sum >= target) {
                min = Math.min(min, R - L + 1);
                sum -= nums[L];
                L++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}