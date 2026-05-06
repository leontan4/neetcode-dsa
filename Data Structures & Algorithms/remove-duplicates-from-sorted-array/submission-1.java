class Solution {
    public int removeDuplicates(int[] nums) {
        int L = 0;

        for(int R = 1; R < nums.length; R++){
            if(nums[R] != nums[L]){
                L++;
                nums[L] = nums[R];
            }
        }

        return L+1;
    }
}