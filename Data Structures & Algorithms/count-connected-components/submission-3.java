class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);

        int[] rank = new int[n];
        Arrays.fill(rank, 1);

        for(int[] edge : edges){
            int node = edge[0];
            int nbr  = edge[1];

            int p1 = find(parents, node);
            int p2 = find(parents, nbr);

            if(p1 != p2){
                if(rank[p1] < rank[p2]){
                    parents[p1] = p2;
                    rank[p2] += rank[p1];
                } else{
                    parents[p2] = p1;
                    rank[p1] += rank[p2];
                }
            }
        }

        int count = 0;
        for(int p : parents){
            if(p == -1) count++;
        }

        return count;
    }

    public int find(int[] parents, int i){
        if(parents[i] == -1){
            return i;
        }

        int p = find(parents, parents[i]);
        parents[i] = p;
        return p;
    }
}
