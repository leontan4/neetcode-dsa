class Solution {
    public List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, 0);
        return res;
    }

    public void backtrack(List<Integer> curr, int[] nums, int index) {
        if (index > nums.length) {
            return;
        }

        res.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
        // [1,2,3]
        // [1]
        // [[],[1],[1,2],[1,2,3],]
    }
}