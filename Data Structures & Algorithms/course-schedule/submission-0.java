class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
         int n = numCourses;

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            int node = pre[0];
            int nbr = pre[1];

            adj[node].add(nbr);
        }

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int nbr : adj[i]) {
                indegree[nbr]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int nbr : adj[node]) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }

        return res.size() == n ? true : false;
    }
}
