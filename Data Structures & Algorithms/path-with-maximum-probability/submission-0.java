class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, ArrayList<double[]>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int node = edges[i][0];
            int nbr = edges[i][1];
            double wgt = succProb[i];
            adj.get(node).add(new double[] { (double) nbr, wgt });
            adj.get(nbr).add(new double[] { (double) node, wgt });
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[] { start_node, 1 });

        Map<Integer, Double> shortest = new HashMap<>();


        while(!pq.isEmpty()){
            double[] pair = pq.poll();
            int n1 = (int) pair[0];
            double w1 = pair[1];

            if(shortest.containsKey(n1)) continue;
            shortest.put(n1, w1);

            for(double[] v : adj.get(n1)){
                double n2 = v[0];
                double w2 = v[1];
                
                if(!shortest.containsKey((int) n2)){
                    double currWeight = w2 * w1;
                    pq.offer(new double[]{n2, currWeight});
                }
            }
        }

        return shortest.get(end_node) == null ? 0.0 : shortest.get(end_node);
    }
}