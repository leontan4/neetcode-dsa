class KthLargest {
    public PriorityQueue<Integer> pq;
    public int size;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        size = k;

        for(int num : nums){
            this.add(num);
        }
    }
    
    public int add(int val) {
        if(pq.isEmpty() || pq.size() < size){
            pq.offer(val);
        } else if(pq.peek() <= val){
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}
