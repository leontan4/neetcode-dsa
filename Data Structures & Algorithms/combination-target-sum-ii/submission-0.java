class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> comb = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);

        dfs(0, nums, target);
        return res;
    }

    public void dfs(int pos, int[] nums, int target){
        if(target == 0){
            res.add(new ArrayList<>(comb));
            return;
        }

        if(pos > nums.length || target < 0){
            return;
        }

        for(int index = pos; index < nums.length; index++){
            
            if(target - nums[index] < 0) {
                return;
            }

            comb.add(nums[index]);
            dfs(index + 1, nums, target - nums[index]);
            
            while(index + 1 < nums.length && nums[index] == nums[index + 1]){
                index++;
            }
            comb.remove(comb.size() - 1);
        }
    }
}