class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        // 1. Create Map of adjacency list
        // 2. Store the edges and weight in adj list
        // 3. Create map to keep track of shortest path
        // 4. Create minHeap to always retrieve shortest weight
        // 5. Return the result of the map of shortest

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
        // PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Queue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

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

                int currWeight = w1 + w2;
                if(!shortest.containsKey(n2)){
                    minHeap.offer(new int[]{currWeight, n2});
                }
            }
        }
        return shortest;
    }  
}
