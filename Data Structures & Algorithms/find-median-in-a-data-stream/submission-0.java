class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b-a);
    }
    
    public void addNum(int num) {
        
        // add the number to maxHeap first
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.offer(num);
        } else{
            minHeap.offer(num);
        }

        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        } else if(minHeap.size() > maxHeap.size() + 1){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // Compare size to retrieve median

        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        } else if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        } 
        return (maxHeap.peek() + minHeap.peek())/ 2.0;
    }
}
