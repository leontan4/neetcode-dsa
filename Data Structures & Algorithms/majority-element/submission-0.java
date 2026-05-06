class Solution {
    public int majorityElement(int[] nums) {

        int k = nums.length / 2;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        for(int num : nums){
            
            map.put(num, map.getOrDefault(num, 0) + 1);
            int freq = map.get(num);

            if(max < freq){
                max = freq;
                res = num;
            }
        }

        return res;
    }
}