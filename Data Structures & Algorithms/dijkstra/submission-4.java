class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for(int i=0; i<n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(List<Integer> edge : edges){
            int node   = edge.get(0);
            int nbr    = edge.get(1);
            int weight = edge.get(2);

            adj.get(node).add(new int[]{nbr, weight});
        }

        Map<Integer, Integer> shortest = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, src});

        while(!minHeap.isEmpty()){
            int[] pair = minHeap.poll();
            int w1 = pair[0];
            int n1 = pair[1];

            if(shortest.containsKey(n1)) continue;
            shortest.put(n1, w1);

            for(int[] v : adj.get(n1)){
                int n2 = v[0];
                int w2 = v[1];
                
                if(!shortest.containsKey(n2)){
                    minHeap.offer(new int[]{w1 + w2, n2});
                }
            }
        }
        // for (int i = 0; i < n; i++) {
        //     shortest.putIfAbsent(i, -1);
        // }
        return shortest;
    }  
}
