class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> comb = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, 1, k);
        return res;
    }

    public void dfs(int n, int i, int k){
        if(comb.size() == k){
            res.add(new ArrayList<>(comb));
            return;
        }   

        if(i > n) return;

        comb.add(i);
        dfs(n, i + 1, k);

        comb.remove(comb.size() - 1);
        dfs(n, i + 1, k);
    }
}