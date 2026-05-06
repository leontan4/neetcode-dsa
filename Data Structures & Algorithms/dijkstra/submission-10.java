class Solution {
    public List<int[]>[] adj;
    public int[] dist;
    public boolean[] visited;

    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        adj = new ArrayList[n];
        dist = new int[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        for(List<Integer> edge : edges){
            int node   = edge.get(0);
            int nbr    = edge.get(1);
            int weight = edge.get(2);
            adj[node].add(new int[]{nbr, weight});
        }

        // [[0,1,10], [0,2,3], [1,3,2], [2,1,4], [2,3,8], [2,4,2], [3,4,5]]
        // {
        // 0:[1,10],[2,3]
        // 1:[3,2]
        // 2:[1,4],[3,8],[4,2]
        // 3:[4,5]
        // 4:[]
        // }
        PriorityQueue<int[]> shortest = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[1], b[1]);
            }
        });

        shortest.offer(new int[]{src, 0});
        dist[src] = 0;
        
        while(!shortest.isEmpty()){
            int[] pair = shortest.poll();
            int node = pair[0];
            int w1   = pair[1];

            if(visited[node]) continue;
            visited[node] = true;

            for(int[] v : adj[node]){
                int nbr = v[0];
                int w2  = v[1];
                int currDist = w1 + w2;

                if(dist[nbr] > currDist){
                    dist[nbr] = currDist;
                    shortest.offer(new int[]{nbr, dist[nbr]});
                }
            }
        }

        Map<Integer, Integer> res = new HashMap<>();
        for(int i=0; i<dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
            res.put(i, dist[i]);
        }
        return res;
    }  
}
