class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int index){
        // base case
        if(index >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        // include elem
        subset.add(nums[index]);
        dfs(nums, index + 1);
        
        // exclude elem
        subset.remove(subset.size() - 1);

        // we also need to check if nums[i] == nums[i + 1]
        while(index + 1 < nums.length && nums[index] == nums[index + 1]){
            index++;
        }
        dfs(nums, index + 1);
    }
}
