class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            int elem = nums[i];

            if(!set.contains(elem)){
                set.add(elem);
            } else{
                return true;
            }
        }
        return false;
    }
}