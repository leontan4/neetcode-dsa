class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        // Arrays.fill(parents, -1);

        int[] rank = new int[n];
        // Arrays.fill(rank, 1);

        for(int i=0; i<n; i++){
            parents[i] = i;
            rank[i] = 1;
        }

        for(int[] v : edges){
            int p1 = find(parents, v[0]);
            int p2 = find(parents, v[1]);

            if(p1 != p2){
                if(rank[p1] < rank[p2]){
                    parents[p1] = p2;
                    rank[p2] += rank[p1];
                }else{
                    parents[p2] = p1;
                    rank[p1] += rank[p2];
                }
            }
        }
        int count = 1;
        int curr = parents[0];

        for(int i=1; i<parents.length; i++){
            if(parents[i] != curr){
                curr = parents[i];
                count++;
            }
        }
        return count;
    }

    public int find(int[] parents, int i){
        if(parents[i] == i){
            return i;
        }
        int p = find(parents, parents[i]);
        parents[i] = p;
        return p;
    }
}
