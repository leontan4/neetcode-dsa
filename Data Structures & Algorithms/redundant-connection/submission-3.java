class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        int[] parents = new int[n];
        Arrays.fill(parents, -1);

        int[] ranks = new int[n];
        Arrays.fill(ranks, 1);

        for(int[] edge : edges){
            int node = edge[0];
            int nbr = edge[1];

            int p1 = find(parents, node);
            int p2 = find(parents, nbr);

            if(p1 == p2) return edge;
            if(p1 != p2){
                if(ranks[p1] < ranks[p2]){
                    ranks[p2] += ranks[p1];
                    parents[p1] = p2;
                } else{
                    ranks[p1] += ranks[p2];
                    parents[p2] = p1;
                }
            }
        }
        return new int[]{-1, -1};
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
