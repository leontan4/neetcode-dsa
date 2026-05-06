class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // [1,0,1,1,0,1,1,1]
        int k = 0;
        int winStart=0;
        int max = 0;

        for(int winEnd=0; winEnd<nums.length; winEnd++){
            if(nums[winEnd] == 0){
                k++;
            }

            while(k > 1){
                if(nums[winStart] == 0){
                    k--;
                }
                winStart++;
            }

            max = Math.max(winEnd - winStart + 1, max);
        }
        return max;
    }
}
