class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int index){
        if(index >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, index + 1);

        subset.remove(subset.size() - 1);
        while(index + 1 < nums.length && nums[index] == nums[index + 1]){
            index++;
        }
        dfs(nums, index + 1);
    }
}
