class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        // 1. create adjacency list
        // 2. create minHeap
        // 3. create visited hashset (if nodes are not continuous)

        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i=0; i<n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(List<Integer> edge : edges){
            int node   = edge.get(0);
            int nbr    = edge.get(1);
            int weight = edge.get(2);

            adj.get(node).add(new int[]{nbr, weight});
            adj.get(nbr).add(new int[]{node, weight});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, 0});

        Set<Integer> visited = new HashSet<>();
        int total = 0;
        while(!minHeap.isEmpty()){
            int[] pair = minHeap.poll();
            int w1 = pair[0];
            int n1 = pair[1];

            if(visited.contains(n1)) continue;
            visited.add(n1);
            total += w1;
            for(int[] v : adj.get(n1)){
                int n2 = v[0];
                int w2 = v[1];
                if(!visited.contains(n2)){
                    minHeap.offer(new int[]{w2, n2});
                }
            }
        }
        return total;
    }
}    
