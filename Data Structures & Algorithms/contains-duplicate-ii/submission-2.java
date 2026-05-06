class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int R = 0; R < nums.length; R++){
            if(!map.containsKey(nums[R])){
                map.put(nums[R], R);
            } else{
                int L = map.get(nums[R]);
                if(Math.abs(R - L) > k){
                    return false;
                }
            }
        }

        return true;
    }
}