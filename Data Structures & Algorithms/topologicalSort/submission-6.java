class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> path = new HashSet<>();

    public List<Integer> topologicalSort(int n, int[][] edges) {
        // DFS topological sort
        // 1. Implement hashmap adj to store edges
        // 2. We create a hashset for 'visited' a certain node
        // 3. 

        for(int i=0; i<n ;i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            int node = edge[0];
            int nbr  = edge[1];
            adj.get(node).add(nbr);
        }

        for(int i=0; i<n; i++){
            if(!dfs(i)){
                return new ArrayList<>();
            }
            
        }
        Collections.reverse(res);
        return res;
    }

    public boolean dfs(int node){
        if(visited.contains(node)){
            return true;
        }

        if(path.contains(node)){
            return false;
        }

        path.add(node);
        for(int nbr : adj.get(node)){
            if(!dfs(nbr)){
                return false;
            }
        }

        path.remove(node);
        visited.add(node);
        res.add(node);
        return true;
    }
}
