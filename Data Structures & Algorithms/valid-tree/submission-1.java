class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Union Find method
        // 1. declare parent
        // 2. declare rank
        // 3. path compression

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        int[] rank = new int[n];
        Arrays.fill(rank, -1);

        for(int[] edge : edges){
            int p1 = find(parent, edge[0]);
            int p2 = find(parent, edge[1]);

            if(p1 != p2){
                if(rank[p1] < rank[p2]){
                    parent[p1] = p2;
                    rank[p2] += rank[p1];
                } else{
                    parent[p2] = p1;
                    rank[p1] += rank[p2];
                }
            } else{
                return false;
            }
        }

        int count = 0;
        for(int i=0; i<parent.length; i++){
            if(parent[i] == -1){
                count++;
            }
        }

        return count == 1;
    }

    public int find(int[] parent, int i){
        if(parent[i] == -1){
            return i;
        }

        int p = find(parent, parent[i]);
        parent[i] = p;
        return p;
    }
}
