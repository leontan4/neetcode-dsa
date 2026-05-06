class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] v : edges){
            int p1 = find(parent, v[0]);
            int p2 = find(parent, v[1]);

            if(p1 != p2){
                if(rank[p1] < rank[p2]){
                    parent[p1] = p2;
                    rank[p2] += rank[p1];
                }else{
                    parent[p2] = p1;
                    rank[p1] += rank[p2];
                }
            } else{
                return v;
            }
        }
        return new int[]{0, 0};
    }

    public int find(int[] parent, int i){
        if(parent[i] == i){
            return i;
        }

        int p = find(parent, parent[i]);
        parent[i] = p;
        return p;
    }
}
