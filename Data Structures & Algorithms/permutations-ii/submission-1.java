class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        Arrays.fill(seen, false);
        Arrays.sort(nums);
        
        backtrack(new ArrayList<>(), nums, seen);
        return res;
    }

    public void backtrack(List<Integer> curr, int[] nums, boolean[] seen) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int index = 0; index < nums.length; index++) {
            if(seen[index]) continue;
            if (index > 0 && nums[index] == nums[index - 1] && !seen[index - 1]) {
                continue;
            }
            curr.add(nums[index]);
            seen[index] = true;
            backtrack(curr, nums, seen);
            curr.remove(curr.size() - 1);
            seen[index] = false;
        }
    }
}