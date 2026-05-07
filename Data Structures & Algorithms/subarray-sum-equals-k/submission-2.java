class Solution {
    public int subarraySum(int[] nums, int k) {
        int curr = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int num : nums){
            curr += num;
            int diff = curr - k;

            count += map.getOrDefault(diff, 0);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return count;
    }
}