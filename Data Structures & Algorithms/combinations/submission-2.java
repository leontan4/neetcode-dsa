class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> comb = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return res;
    }

    public void dfs(int pos, int n, int k){
        if(comb.size() == k){
            res.add(new ArrayList<>(comb));
            return;
        }

        if(pos > n) return;

        for(int index = pos; index < n + 1; index++){
            comb.add(index);
            dfs(index + 1, n, k);
            comb.remove(comb.size() - 1);
        }
    }
}