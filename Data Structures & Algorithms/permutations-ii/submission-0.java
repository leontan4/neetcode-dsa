class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return new ArrayList<>(dfs(0, nums));
    }

    public Set<List<Integer>> dfs(int index, int[] nums){
        // if index == nums.length, then we want to create empty list
        // initialize perm array
        if(index == nums.length){
            Set<List<Integer>> res = new HashSet<>();
            res.add(new ArrayList<>());
            return res;
        }

        Set<List<Integer>> resPerms = new HashSet<>();
        Set<List<Integer>> perms = dfs(index + 1, nums);

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