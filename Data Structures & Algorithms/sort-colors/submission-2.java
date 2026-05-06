class Solution {
    public void sortColors(int[] nums) {
        if(nums.length <= 1) return;
        int[] bucket = new int[nums.length + 1];
        for(int num : nums){
            bucket[num]++;
        }

        int index = 0;

        // [1, 2, 1]
        //  0  1  2
        for(int i = 0; i<bucket.length; i++){
            if(bucket[i] >= 0){
                for(int j=0; j<bucket[i]; j++){
                    nums[index] = i;
                    index++;
                }
            }
        }
    }
}