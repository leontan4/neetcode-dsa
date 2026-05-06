class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }

        for (int[] time : times) {
            int node = time[0];
            int nbr = time[1];
            int weight = time[2];
            adj[node].add(new int[] { nbr, weight });
        }

        dist[k] = -1;
        visited[0] = true;

        PriorityQueue<int[]> shortest = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        shortest.offer(new int[] { k, 0 });

        while (!shortest.isEmpty()) {
            int[] pair = shortest.poll();
            int node = pair[0];
            int w1 = pair[1];

            for (int[] v : adj[node]) {
                int nbr = v[0];
                int w2 = v[1];
                int currDist = w1 + w2;

                if (dist[nbr] > currDist) {
                    dist[nbr] = currDist;
                    shortest.offer(new int[] { nbr, dist[nbr] });
                }
            }
        }

        int max = 0;
        for (int i = 1; i < dist.length; i++) {
            max = Math.max(max, dist[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}