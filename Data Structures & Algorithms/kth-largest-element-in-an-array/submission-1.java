class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){

            if(minHeap.size() >= k){
                if(minHeap.peek() < num){
                    minHeap.poll();
                    minHeap.offer(num);
                }
            } else{
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }
}
