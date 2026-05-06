class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        // 1. We create adjacency list for edges
        // 2. We create indegree for edges
        // 3. We will then loop to the indegree and count
        // 4. Initialize Q and add 0 indegree nodes
        // 5. loops Q, deduct indegree count and add 0 indegree nodes (rinse and repeat)

        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int node = edge[0];
            int nbr  = edge[1];

            adj[node].add(nbr);
        }

        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            for(int nbr : adj[i]){
                indegree[nbr]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for(int nbr : adj[node]){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }
        return res.size() == n ? res : 0;
    }
}
