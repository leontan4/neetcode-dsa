class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            int elem = nums[i];

            if(set.contains(elem)){
                return true;
            }
            set.add(elem);
        }
        return false;
    }
}