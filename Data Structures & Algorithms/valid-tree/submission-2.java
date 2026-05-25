class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);

        int[] ranks = new int[n];
        Arrays.fill(ranks, 1);

        for (int[] edge : edges) {
            int node = edge[0];
            int nbr = edge[1];

            int p1 = find(parents, node);
            int p2 = find(parents, nbr);

            System.out.println("Node: " + node);
            System.out.println("parent: " + p1);

            System.out.println("Nbr: " + nbr);
            System.out.println("parent: " + p2);
            System.out.println();

            if (p1 != p2) {
                if (ranks[p1] < ranks[p2]) {
                    ranks[p2] += ranks[p1];
                    parents[p1] = p2;
                } else {
                    ranks[p1] += ranks[p2];
                    parents[p2] = p1;
                }
            } else{
                return false;
            }
        }
        return true;
    }

    public int find(int[] parents, int i) {
        if (parents[i] == -1) {
            return i;
        }
        int p = find(parents, parents[i]);
        parents[i] = p;
        return p;
    }
}
