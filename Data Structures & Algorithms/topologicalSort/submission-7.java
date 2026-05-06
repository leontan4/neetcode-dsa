class Solution {

    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> visitingStack = new HashSet<>();
    List<Integer> res = new ArrayList<>();

    public List<Integer> topologicalSort(int n, int[][] edges) {
        // 1. detecting cycle with "stack"
        // 2. mark each node visited
        
        // Create adj list
        for(int i=0; i<n; i++){
            adj.put(i, new ArrayList<>());
        }

        // directed graph so we only add node -> nbr
        // if undirected then node -> nbr and nbr -> node
        for(int[] edge : edges){
            int node = edge[0];
            int nbr  = edge[1];

            adj.get(node).add(nbr);
        }

        // Loop through each node to determine if there is a cycle or not
        for(int node = 0; node < n; node++){
            // if cycle detected we return empty array
            if(!dfs(node)){
                return new ArrayList<>();
            }
        }
        Collections.reverse(res);
        return res;
    }

    public boolean dfs(int node){
        // when we complete visit a node we return true
        if(visited.contains(node)) return true;

        // when we are visiting a new node and it's already been seen
        // we would return false
        if(visitingStack.contains(node)) return false;

        // if not visiting then we add to visiting stack
        visitingStack.add(node);

        // we want to traverse the nbr nodes
        // cycle detected 
        for(int nbr : adj.get(node)){
            if(!dfs(nbr)){
                return false;
            }
        }
        // if we are able to get out of the loop it means no cycle
        // we can remove from visitingStack (backtrack) and add the nodes to visited
        visitingStack.remove(node);
        visited.add(node);
        res.add(node);

        return true;
    }
}
