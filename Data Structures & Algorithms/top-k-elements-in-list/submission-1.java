class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
                @Override
                public int compare(int[] a, int[] b){
                    return a[1] - b[1];
                }
                // lambda method
                // (a, b) -> a[1] - b[1]
            }
        );

        // {1:1, 2:2, 3:3}
        for(int num : freq.keySet()){
            int count = freq.get(num);

            pq.offer(new int[]{num, count});

            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            int num = pq.poll()[0];
            res[i] = num;
        }
        
        return res;
    }
}