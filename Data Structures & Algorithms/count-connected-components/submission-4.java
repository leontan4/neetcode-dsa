class Solution {
    public HashSet<Integer> seen;
    public int count = 0;
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];

        for(int i=0; i<adj.length; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int node = edge[0];
            int nbr  = edge[1];

            adj[node].add(nbr);
            adj[nbr].add(node);
        }

        seen = new HashSet<>();

        for(int i=0; i<adj.length; i++){
            if(!seen.contains(i)){
                dfs(adj, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(List<Integer>[] adj, int node){
        seen.add(node);

        for(int nbr : adj[node]){
            if(!seen.contains(nbr)){
                dfs(adj, nbr);
            }
        }
    }
}
