class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int elem = nums[i];

            if(!map.containsKey(elem)){
                map.put(nums[i], 1);
            } else{
                return true;
            }
        }
        return false;
    }
}