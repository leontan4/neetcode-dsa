class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            int node = time[0];
            int nbr = time[1];
            int wgt = time[2];

            adj.get(node).add(new int[] {nbr, wgt});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[] {k, 0});

        Map<Integer, Integer> shortest = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int n1 = pair[0];
            int w1 = pair[1];

            if (shortest.containsKey(n1))
                continue;
            shortest.put(n1, w1);

            for (int[] v : adj.get(n1)) {
                int n2 = v[0];
                int w2 = v[1];

                if (!shortest.containsKey(n2)) {
                    int currWeight = w1 + w2;
                    pq.offer(new int[] {n2, currWeight});
                }
            }
        }

        if(shortest.size() < n) return -1;

        int maxTime = -1;

        for(int time : shortest.values()){
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }
}
