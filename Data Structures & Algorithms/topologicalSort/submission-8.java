class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int node = edge[0];
            int nbr = edge[1];

            adj[node].add(nbr);
            inDegree[nbr]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for(int nbr : adj[node]){
                inDegree[nbr]--;

                if(inDegree[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }
        return res;
    }
}
