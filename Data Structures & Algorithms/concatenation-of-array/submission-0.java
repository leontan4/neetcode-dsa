class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];

        int k = 0;
        for(int i=0; i<res.length; i++){
            res[i] = nums[k];
            k++;

            if(k == nums.length) {
                k = 0;
            }
        }
        return res;
    }
}