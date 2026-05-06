class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 0) return 0;
        Arrays.sort(nums);
        int currMax = 1;
        int max = 1;
        int n = nums.length;

        for(int i=0; i<n-1; i++){
            if(nums[i] == nums[i + 1]){
                continue;
            }
            if(nums[i+1] - nums[i] == 1){
                currMax++;
            } else if(nums[i+1] - nums[i] > 1){
                currMax = 1;
            }
            max = Math.max(currMax, max);
        }

        return max;
    }
}
