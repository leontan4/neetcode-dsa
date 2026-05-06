class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int x = nums[i];

            int y = target - x;

            if(map.containsKey(x)){
                
                return new int[]{map.get(x), i};
            } 

            map.put(y, i);
        }

        return new int[]{-1, -1};
    }
}