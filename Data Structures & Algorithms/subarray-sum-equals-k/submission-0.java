class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int curr = 0;
        map.put(0, 1);
        for(int num : nums){
            curr += num; 

            int y = curr - k;
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            res += map.getOrDefault(y, 0);
        }
        return res;
    }
}