class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length <= 1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });

        for(int i=0; i<stones.length; i++){
            pq.offer(stones[i]);
        }

        while(!pq.isEmpty()){
            int firstElem = pq.poll();
            int secondElem = pq.poll();
            
            int diff = firstElem - secondElem;

            if(diff != 0){
                pq.offer(diff);
            }
            if(pq.size() == 1){
                return pq.peek();
            }
        }
        return 0;
    }
}
