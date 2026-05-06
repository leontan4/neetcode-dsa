class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, target, 0);
        return res;
    }
    
    // [10,1,2,7,6,1,5]
    // [1,1,2,5,6,7,10]
    public void backtrack(List<Integer> curr, int[] candidates, int target, int pos){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || pos > candidates.length) return;

        for(int index = pos; index < candidates.length; index++){
            if(index > pos && candidates[index] == candidates[index - 1]) continue;
            curr.add(candidates[index]);
            backtrack(curr, candidates, target - candidates[index], index + 1);
            curr.remove(curr.size() - 1);
        }
    }
}