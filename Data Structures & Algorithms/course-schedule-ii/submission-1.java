class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<Integer>[] adj = new ArrayList[n];
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        
        for (int[] pre : prerequisites) {
            int nbr = pre[0];
            int node = pre[1];

            adj[node].add(nbr);
            inDegree[nbr]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int[] res = new int[n];
        int index = 0;
        while (!q.isEmpty()) {

            int node = q.poll();
            res[index] = node;
            index++;

            for (int nbr : adj[node]) {
                inDegree[nbr]--;
                if (inDegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }

        if(index == n) return res;
        return new int[0];
    }
}