class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int elem = entry.getKey();
            int count = entry.getValue();
            int[] freq = {elem, count};

            if(minHeap.isEmpty() || minHeap.size() < k){
                minHeap.offer(freq);
            } else if(count > minHeap.peek()[1]){
                minHeap.poll();
                minHeap.offer(freq);
            }
        }
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = minHeap.poll()[0];
        }

        return res;
        
    }
}
