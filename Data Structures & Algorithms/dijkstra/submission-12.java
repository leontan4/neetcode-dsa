class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (List<Integer> edge : edges) {
            int node = edge.get(0);
            int nbr = edge.get(1);
            int wgt = edge.get(2);

            adj[node].add(new int[] {nbr, wgt});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] {src, 0});

        Map<Integer, Integer> shortest = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] dist = pq.poll();
            int n1 = dist[0];
            int w1 = dist[1];

            if (shortest.containsKey(n1))
                continue;
            shortest.put(n1, w1);

            for (int[] v : adj[n1]) {
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
