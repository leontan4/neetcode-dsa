class Solution {

    private int inf = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, inf);

        dist[src] = 0;

        for(int i=0; i<=k; i++){
            int[] temp = Arrays.copyOf(dist, n);

            for(int[] flight : flights){
                int node = flight[0];
                int nbr  = flight[1];
                int wt   = flight[2];

                if(dist[node] != inf){
                    if(dist[node] + wt < temp[nbr]){
                        temp[nbr] = dist[node] + wt;
                    }
                } 
            }
            dist = temp;
        }
        return dist[dst] == inf ? -1 : dist[dst];
    }
}
