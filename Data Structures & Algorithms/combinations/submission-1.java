class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> comb = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return res;
    }

    public void dfs(int pos, int n, int k){
        // base case
        if(comb.size() == k){
            res.add(new ArrayList<>(comb));
            return;
        }

        if(pos > n){
            return;
        }

        // comb.add(pos);
        // dfs(pos + 1, n, k);

        // comb.remove(comb.size() - 1);
        // dfs(pos + 1, n, k);

        // Looping through each recursively
        // n + 1 to include n
        for(int index = pos; index < n + 1; index++){
            // Add elem
            comb.add(index);
            dfs(index + 1, n, k);
            // Remove elem
            comb.remove(comb.size() - 1);
        }
    }
}