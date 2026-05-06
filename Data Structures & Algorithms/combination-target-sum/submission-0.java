class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> comb = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, target, candidates, 0);
        return res;
    }

    public void dfs(int sum, int target, int[] nums, int pos){
        // base case
        if(sum == target){
            res.add(new ArrayList<>(comb));
            return;
        }
        
        if(pos >= nums.length || sum < 0){
            return;
        }
        
        // Loop through to get the elem
        for(int index = pos; index < nums.length; index++){
            if(sum + nums[index] > target){
                return;
            }

            // add elem
            comb.add(nums[index]);
            dfs(sum + nums[index], target, nums, index);

            // remove elem (backtracking)
            comb.remove(comb.size() - 1);
        }
    }
}