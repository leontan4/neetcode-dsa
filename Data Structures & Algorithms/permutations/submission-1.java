class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // Recursive method

        return dfs(0, nums);
    }

    public List<List<Integer>> dfs(int index, int[] nums){
        if(index == nums.length){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }

        List<List<Integer>> resPerms = new ArrayList<>();
        List<List<Integer>> perms = dfs(index + 1, nums);

        for(List<Integer> p : perms){
            for(int pos = 0; pos < p.size() + 1; pos++){
                List<Integer> pCopy = new ArrayList<>();
                pCopy.addAll(p);
                pCopy.add(pos, nums[index]);
                resPerms.add(pCopy);
            }
        }
        return resPerms;
    }
}
