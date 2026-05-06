class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int i=0; i<n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(List<Integer> edge : edges){
            int node = edge.get(0);
            int nbr = edge.get(1);
            int weight = edge.get(2);

            adj.get(node).add(new int[]{nbr, weight});
        }

        Map<Integer, Integer> res = new HashMap<>();
        Queue<int[]> shortest = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        shortest.offer(new int[]{0, src});

        while(!shortest.isEmpty()){
            int[] path = shortest.poll();
            int w1 = path[0];
            int n1 = path[1];

            if(res.containsKey(n1)) continue;
            res.put(n1, w1);

            for(int[] edge : adj.get(n1)){
                int n2 = edge[0];
                int w2 = edge[1];
                int dist = w1 + w2;

                shortest.offer(new int[]{dist, n2});
            }
        }
        for(int i=0; i<n; i++){
            if(!res.containsKey(i)){
                res.put(i, -1);
            }
        }
        return res;
    }  
}
