class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        // 1. Create Map of adjacency list
        // 2. Store the edges and weight in adj list
        // 3. Create map to keep track of shortest path
        // 4. Create minHeap to always retrieve shortest weight
        // 5. Return the result of the map of shortest

        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int node = edge.get(0);
            int nbr = edge.get(1);
            int wgt = edge.get(2);

            adj.get(node).add(new int[]{nbr, wgt});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { return Integer.compare(a[1], b[1]); });
        pq.offer(new int[] {src, 0});

        Map<Integer, Integer> shortest = new HashMap<>();

        while (!pq.isEmpty()) {
            // poll out the shortest path
            int[] pair = pq.poll();
            int n1 = pair[0];
            int w1 = pair[1];

            // check if shortest exists in map
            // if shortest exists it means we can skip
            // as minheap always returns shortest
            if (shortest.containsKey(n1))
                continue;

            // if shortest not in map we store it
            shortest.put(n1, w1);

            // this condition we will store the shortest to minHeap and
            // we will loop until we have shortest available to us
            for (int[] v : adj.get(n1)) {
                int n2 = v[0];
                int w2 = v[1];

                if (!shortest.containsKey(n2)) {
                    int currWeight = w1 + w2;
                    pq.offer(new int[] {n2, currWeight});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            shortest.putIfAbsent(i, -1);
        }
        return shortest;
    }
}
