class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int L = 0;

        HashSet<Integer> set = new HashSet<>();

        //  nums = [1,2,3,1], k = 3
        for(int R = 0; R < nums.length; R++){
            if(R - L > k){
                set.remove(nums[L]);
                L++;
            }

            if(set.contains(nums[R]) && Math.abs(R - L) <= k){
                return true;
            }
            set.add(nums[R]);
        }
        return false;
    }
}