class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int winStart=0;
        int max = 0;

        for(int winEnd=0; winEnd<nums.length; winEnd++){
            if(nums[winEnd] == 0){
                count++;
            }

            while(count > k){
                if(nums[winStart] == 0){
                    count--;
                }
                winStart++;
            }

            max = Math.max(winEnd - winStart + 1, max);
        }
        return max;
    }
}