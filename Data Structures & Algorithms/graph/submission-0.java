class Graph {
    public Map<Integer, HashSet<Integer>> adj;
    public Graph() {
        adj = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        adj.putIfAbsent(src, new HashSet<>());
        adj.putIfAbsent(dst, new HashSet<>());
        adj.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if(!adj.containsKey(src) || !adj.get(src).contains(dst)){
            return false;
        }
        adj.get(src).remove(dst);
        return true;
    }

    public boolean hasPath(int src, int dst) {
        HashSet<Integer> seen = new HashSet<>();
        return dfs(src, dst, seen);
    }

    public boolean dfs(int node, int dst, HashSet<Integer> seen){
        if(node == dst) return true;
        seen.add(node);
        for(int nbr : adj.get(node)){
            if(!seen.contains(nbr)){
                if(dfs(nbr, dst, seen)){
                    return true;
                }
            }
        }
        return false;
    }
}
