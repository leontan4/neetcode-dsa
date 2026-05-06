class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        // 1. Create adj list
        // 2. create minHeap, sort by weight (w1, node, nbr)
        // 3. Add to queue and loop condition based on visited

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

        // assign node we want to start to 'src'
        int src = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(src);
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // @Override
        // public int compare(int[] a, int[] b){
        //     return a[0] - b[0];
        // }

        for(int[] edge : adj.get(src)){
            int nbr    = edge[0];
            int weight = edge[1];
            minHeap.offer(new int[]{weight, 0, nbr});
        }

        int weightSum = 0;
        while(visited.size() < n && !minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int w1 = curr[0];
            int nbr = curr[2];

            if(visited.contains(nbr)) continue;

            visited.add(nbr);
            weightSum += w1;

            for(int[] edge : adj.get(nbr)){
                int node = edge[0];
                int w2   = edge[1];

                if(!visited.contains(node)){
                    minHeap.add(new int[]{w2, nbr, node});
                }
            }
        }
        return visited.size() == n ? weightSum : -1;
    }
}    
