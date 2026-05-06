class Solution {
    public int rob(int[] nums) {
        int[] dp = {0, 0};

        for(int num : nums){
            int temp = Math.max(num + dp[0], dp[1]);
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }
}
