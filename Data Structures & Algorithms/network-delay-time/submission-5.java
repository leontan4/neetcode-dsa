class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        // 1. Create adj list with hashmap to store node, nbr and weight
        // 2. Create minHeap to store the minimum weights/paths
        // 3. Another map to store shortest paths from minHeap

        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i=1; i<n+1; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            int node   = edge[0];
            int nbr    = edge[1];
            int weight = edge[2];

            adj.get(node).add(new int[]{nbr, weight});
        }

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, k});

        Map<Integer, Integer> shortest = new HashMap<>();

        while(!minHeap.isEmpty()){
            int[] path = minHeap.poll();
            int w1 = path[0];
            int n1 = path[1];

            if(shortest.containsKey(n1)) continue;
            shortest.put(n1, w1);

            for(int[] edge : adj.get(n1)){
                int n2 = edge[0];
                int w2 = edge[1];
                int distance = w1 + w2;
                minHeap.offer(new int[]{distance, n2});
            }
        }
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : shortest.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        return shortest.size() == n ? max : -1;
    }
}
