class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> visitingStack = new HashSet<>();
    List<Integer> topSort = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int node = pre[0];
            int nbr = pre[1];
            adj.get(node).add(nbr);
        }

        for (int node = 0; node < numCourses; node++) {
            if (!dfs(node)) {
                return new int[]{};
            }
        }

        // Collections.reverse(topSort);

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = topSort.get(i);
        }
        return res;
    }

    public boolean dfs(int node) {
        if (visited.contains(node))
            return true;
        if (visitingStack.contains(node))
            return false;

        visitingStack.add(node);
        for (int nbr : adj.get(node)) {
            if (!dfs(nbr)) {
                return false;
            }
        }

        visitingStack.remove(node);
        visited.add(node);
        topSort.add(node);
        return true;
    }
}
