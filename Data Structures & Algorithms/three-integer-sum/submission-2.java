class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // First thing we have to do is sort it
        // because once we sort it, we can then use two pointers
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // [-1,0,1,2,-1,-4]
        // [-4,-1,-1,0,1,2]
        // We will have three pointers (i, j and k)
        // j will always be i + 1 and k start from the end and k > j > i
        int n = nums.length;
        for(int i=0; i<n; i++){
            int j = i + 1;
            int k = n-1;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                } else if(sum > 0){
                    k--;
                } else{
                    j++;
                }
            }
        }
        return res;
    }
}
