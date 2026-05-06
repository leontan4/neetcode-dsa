class Solution {
    public int removeElement(int[] nums, int val) {
        int L = 0;
        for(int R = 0; R < nums.length; R++){
            if(nums[R] != val){
                nums[L] = nums[R];
                L++;
            }
        }
        return L;
    }
}