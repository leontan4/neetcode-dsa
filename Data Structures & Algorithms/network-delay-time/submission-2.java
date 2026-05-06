class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
        for(int i=1; i<=n; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] time : times){
            int node   = time[0];
            int nbr    = time[1];
            int weight = time[2];

            adj.get(node).add(new int[]{nbr, weight});
        }

        for(List<int[]> v: adj.values()){
            for(int[] pair : v){
                int node = pair[0];
                int weight = pair[1];

                System.out.println("This is node: " + node);
                System.out.println("This is weight: " + weight);
                System.out.println();
            }
        }
        

        Map<Integer, Integer> shortest = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, k});

        // shortest.put(0, -1);
        while(!minHeap.isEmpty()){
            int[] pair = minHeap.poll();
            int w1 = pair[0];
            int n1 = pair[1];

            if(shortest.containsKey(n1)) continue;
            shortest.put(n1, w1);
        
            for(int[] v: adj.get(n1)){
                int n2 = v[0];
                int w2 = v[1];
                int currWeight = w1 + w2;
                if(!shortest.containsKey(n2)){
                    minHeap.offer(new int[]{currWeight, n2});
                }
            }
        }

        if (shortest.size() < n) return -1;
        int maxTime = -1;

        for(int time : shortest.values()){
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
        // for(int i=0; i<n; i++){
        //     if(!shortest.containsKey(i)){
        //         return -1;
        //     }
        // }

        // return -1;
        // return shortest.size();
    }
}
